package com.pro1.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户绑定表
 */
@Entity
@Data
public class UserInfo {

    @Id
    private String userOpenid;

    private String diagnosiscardId;
}
