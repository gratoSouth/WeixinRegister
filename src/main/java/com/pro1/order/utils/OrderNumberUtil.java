package com.pro1.order.utils;

import com.pro1.order.dataobject.Schedule;

/**
 * 计算挂号号数
 */
public class OrderNumberUtil {

    public static synchronized Integer orderNumber(Schedule schedule){

        return schedule.getOrderAmount() - schedule.getOrderRest() + 1;
    }
}
