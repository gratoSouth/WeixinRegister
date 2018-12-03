package com.pro1.order.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class OrderDTO {

    /** 日程id. */
    private String scheduleId;

    private String openId;
}
