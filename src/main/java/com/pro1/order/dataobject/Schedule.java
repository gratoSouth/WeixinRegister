package com.pro1.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 工作日程
 */
@Entity
@DynamicUpdate
@Data
public class Schedule {

    /**日程id. */
    @Id
    private String scheduleId;

    /**医生id. */
    private Integer doctorId;

    /**工作日程日期. */
    private String scheduleDate;

    /**日程具体时间. */
    private String dateDetail;

    /**挂号数量. */
    private Integer orderAmount;

    /**挂号剩余数量. */
    private Integer orderRest;

    /**诊断地点. */
    private String workPlace;

    /**挂号费用. */
    private BigDecimal orderFee;
}
