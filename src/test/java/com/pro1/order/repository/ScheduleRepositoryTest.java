package com.pro1.order.repository;

import com.pro1.order.dataobject.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository repository;
    @Test
    public void saveTest(){

        Schedule schedule = new Schedule();
        schedule.setScheduleId("00001");
        schedule.setDoctorId(1);
        schedule.setScheduleDate("2018-11-12");
        schedule.setDateDetail("上午");
        schedule.setOrderAmount(30);
        schedule.setOrderRest(30);
        schedule.setWorkPlace("107");
        schedule.setOrderFee(new BigDecimal(3.2));

        Schedule result = repository.save(schedule);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByDoctorId() {
        List<Schedule> scheduleList = repository.findByDoctorId(1);
        Assert.assertNotEquals(0, scheduleList.size());
    }
}