package com.pro1.order.service;

import com.pro1.order.dataobject.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule findOne(String scheduleId);

    List<Schedule> findByDoctorId(Integer doctorId);

    //减挂号库存
    void decreaseStock(String scheduleId);
}
