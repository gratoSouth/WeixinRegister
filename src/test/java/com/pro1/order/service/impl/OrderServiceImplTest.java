package com.pro1.order.service.impl;

import com.pro1.order.dataobject.OrderDetail;
import com.pro1.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String UserOpenid = "00001";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOpenId(UserOpenid);
        orderDTO.setScheduleId("00001");

        OrderDetail result = orderService.create(orderDTO);
        log.info("【创建预约表】 result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {
        List<OrderDetail> orderDetailList = orderService.findList("00001");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}