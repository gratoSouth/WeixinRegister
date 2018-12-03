package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DoctorInfo;
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
public class DoctorInfoServiceImplTest {

    @Autowired
    private DoctorInfoServiceImpl doctorInfoService;

    @Test
    public void findByDepartmentType(){
        List<DoctorInfo> doctorInfoList = doctorInfoService.findByDepartmentType(1);
        Assert.assertNotEquals(0, doctorInfoList.size());
    }

    @Test
    public void findByDoctorNameLike(){
        List<DoctorInfo> doctorInfoList = doctorInfoService.findByDoctorNameLike("小");
        Assert.assertNotEquals(0, doctorInfoList.size());
    }
}