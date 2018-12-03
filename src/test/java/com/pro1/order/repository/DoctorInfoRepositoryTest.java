package com.pro1.order.repository;

import com.pro1.order.dataobject.DoctorInfo;
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
public class DoctorInfoRepositoryTest {

    @Autowired
    private DoctorInfoRepository repository;

    @Test
    public void saveTest(){
        DoctorInfo doctorInfo = new DoctorInfo();
        doctorInfo.setDepartmentType(1);
        doctorInfo.setDoctorDescription("擅长。。。。");
        doctorInfo.setDoctorIcon("http://xxxx.jpg");
        doctorInfo.setDoctorName("小红");

        DoctorInfo result = repository.save(doctorInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        DoctorInfo result = repository.findById(1).orElse(null);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByDepartmentTypeTest(){
        List<DoctorInfo> doctorInfoList = repository.findByDepartmentType(1);
        Assert.assertNotEquals(0, doctorInfoList.size());
    }

    @Test
    public void findByDoctorNameLikeTest(){
        List<DoctorInfo> doctorInfoList = repository.findByDoctorNameLike("%"+"小"+"%");
        Assert.assertNotEquals(0, doctorInfoList.size());
    }
}

