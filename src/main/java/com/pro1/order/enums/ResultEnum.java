package com.pro1.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数不正确"),

    SCHEDULE_NOT_EXIST(10, "日程表不存在"),

    USERINFO_NOT_EXIST(11, "用户不存在"),

    UNBOUND(12, "用户未绑定"),

    SCHEDULE_STOCK_ERROR(13, "挂号剩余库存不正确"),

    DIAGNOSISCARD_NOT_EXIST(14, "就诊卡不存在"),

    INSUFFICIENT_ACCOUNT_BALANCE(15, "账户余额不足"),

    USERINFO_ERROR(16, "用户信息不正确")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
