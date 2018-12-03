package com.pro1.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String orderId;

    /** 就诊卡id. */
    private String diagnosiscardId;

    /** 日程id. */
    private String scheduleId;

    /**科室名称. */
    private String departmentName;

    /**医生名称. */
    private String doctorName;

    /**日程日期. */
    private String scheduleDate;

    /**日程具体时间. */
    private String dateDetail;

    /**挂号号数. */
    private Integer orderNumber;

    /**诊断地点. */
    private String workPlace;

    /**挂号费用. */
    private BigDecimal orderFee;
}
