package com.pro1.order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 日程表
 */
@Data
public class ScheduleVO {

    @JsonProperty("id")
    private String scheduleId;

    private String scheduleDate;

    private String dateDetail;

    private Integer orderAmount;

    private String workPlace;

    private BigDecimal orderFee;
}
