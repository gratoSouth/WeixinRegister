package com.pro1.order.service.impl;

import com.pro1.order.dataobject.Schedule;
import com.pro1.order.service.ScheduleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceImplTest {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Test
    public void findOne() {
        Schedule schedule = scheduleService.findOne("00001");
        Assert.assertNotNull(schedule);
    }

    @Test
    public void findByDoctorId() {
        List<Schedule> scheduleList = scheduleService.findByDoctorId(1);
        Assert.assertNotEquals(0, scheduleList.size());
    }

}