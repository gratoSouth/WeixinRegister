package com.pro1.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    /**
     * 用户openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 日程表id
     */
    @NotEmpty(message = "scheduleid必填")
    private String scheduleid;
}
