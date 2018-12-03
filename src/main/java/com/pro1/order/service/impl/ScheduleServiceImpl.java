package com.pro1.order.service.impl;

import com.pro1.order.dataobject.Schedule;
import com.pro1.order.enums.ResultEnum;
import com.pro1.order.exception.OrderException;
import com.pro1.order.repository.ScheduleRepository;
import com.pro1.order.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Override
    public Schedule findOne(String scheduleId) {
        return repository.findById(scheduleId).orElse(null);
    }

    @Override
    public List<Schedule> findByDoctorId(Integer doctorId) {
        return repository.findByDoctorId(doctorId);
    }

    @Override
    @Transactional
    public void decreaseStock(String scheduleId) {
        Schedule schedule = repository.findById(scheduleId).orElse(null);
        if (schedule == null){
            throw new OrderException(ResultEnum.SCHEDULE_NOT_EXIST);
        }
        Integer result = schedule.getOrderRest() - 1;
        if (result < 0){
            throw new OrderException(ResultEnum.SCHEDULE_STOCK_ERROR);
        }

        schedule.setOrderRest(result);

        repository.save(schedule);
    }
}
