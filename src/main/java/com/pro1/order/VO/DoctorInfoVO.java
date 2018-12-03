package com.pro1.order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 医生信息
 */
@Data
public class DoctorInfoVO {

    @JsonProperty("id")
    private Integer doctorId;

    @JsonProperty("name")
    private String doctorName;

    @JsonProperty("description")
    private String doctorDescription;

    @JsonProperty("icon")
    private String doctorIcon;


}
