package com.pro1.order.exception;

import com.pro1.order.enums.ResultEnum;

public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = code;
    }

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
