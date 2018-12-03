package com.pro1.order.dto;

import lombok.Data;

@Data
public class BindInfoDTO {
    /**
     * 用户openid
     */
    private String openId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户身份证号
     */
    private String userId;

    /**
     * 用户邮箱
     */
    private String userEmail;
}
