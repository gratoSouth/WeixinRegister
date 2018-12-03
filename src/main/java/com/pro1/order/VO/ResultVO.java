package com.pro1.order.VO;

import lombok.Data;

/**
 * http请求的最外层对象
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
