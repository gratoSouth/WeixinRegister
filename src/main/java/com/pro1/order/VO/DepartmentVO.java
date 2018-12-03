package com.pro1.order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 科室信息
 */
@Data
public class DepartmentVO {

    @JsonProperty("name")
    private String departmentName;

    @JsonProperty("type")
    private Integer departmentType;
}
