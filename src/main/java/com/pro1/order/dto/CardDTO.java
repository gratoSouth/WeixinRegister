package com.pro1.order.dto;

import lombok.Data;

@Data
public class CardDTO {

    /** 用户姓名. */
    private String userName;

    /** 用户性别. */
    private String userSex;

    /** 用户邮箱. */
    private String userEmail;

    /** 用户身份证号. */
    private String userId;

    private String openId;
}
