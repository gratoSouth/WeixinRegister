package com.pro1.order.service;

import com.pro1.order.dataobject.OrderDetail;
import com.pro1.order.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    /** 创建订单并支付. */
    OrderDetail create(OrderDTO orderDTO);

    /** 查询订单列表. */
    List<OrderDetail> findList(String userOpenid);

}
