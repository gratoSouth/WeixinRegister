package com.pro1.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BindInfoForm {

    /**
     * 用户openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 用户姓名
     */
    @NotEmpty(message = "姓名必填")
    private String username;

    /**
     * 用户身份证号
     */
    @NotEmpty(message = "身份证号必填")
    private String userid;

    /**
     * 用户邮箱
     */
    @NotEmpty(message = "邮箱必填")
    private String useremail;
}
