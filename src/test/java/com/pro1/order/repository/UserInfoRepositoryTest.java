package com.pro1.order.repository;

import com.pro1.order.dataobject.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired UserInfoRepository repository;

    @Test
    public void saveTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserOpenid("00005");

        UserInfo result = repository.save(userInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest(){
        UserInfo userInfo = repository.findById("00001").orElse(null);
        Assert.assertNotNull(userInfo);
    }
}