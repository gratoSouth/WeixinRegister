package com.pro1.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 就诊卡信息
 */
@Entity
@Data
@DynamicUpdate
public class DiagnosisCard {

    /** 就诊卡号. */
    @Id
    private String diagnosiscardId;

    /** 用户姓名. */
    private String userName;

    /** 用户性别. */
    private String userSex;

    /** 用户邮箱. */
    private String userEmail;

    /** 用户身份证号. */
    private String userId;

    /** 账户余额. */
    private BigDecimal accountBalance;

}
