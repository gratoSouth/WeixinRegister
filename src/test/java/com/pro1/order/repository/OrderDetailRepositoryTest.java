package com.pro1.order.repository;

import com.pro1.order.dataobject.OrderDetail;
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
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123456");
        orderDetail.setDiagnosiscardId("00001");
        orderDetail.setScheduleId("00001");
        orderDetail.setDepartmentName("外科");
        orderDetail.setDoctorName("小明");
        orderDetail.setScheduleDate("2018-11-12");
        orderDetail.setDateDetail("上午");
        orderDetail.setOrderNumber(30);
        orderDetail.setWorkPlace("107");
        orderDetail.setOrderFee(new BigDecimal(3.2));

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByDiagnosiscardId() {
        List<OrderDetail> orderDetailList = repository.findByDiagnosiscardId("00001");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}