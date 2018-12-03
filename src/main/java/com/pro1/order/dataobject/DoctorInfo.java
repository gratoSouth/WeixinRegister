package com.pro1.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 医生信息
 */
@Entity
@DynamicUpdate
@Data
public class DoctorInfo {

    /**医生id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    /**医生名字. */
    private String doctorName;

    /**描述. */
    private String doctorDescription;

    /**医生照片. */
    private String doctorIcon;

    /**科室编号. */
    private Integer departmentType;


}
