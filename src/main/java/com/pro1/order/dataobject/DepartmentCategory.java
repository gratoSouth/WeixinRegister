package com.pro1.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 科室
 */
@Entity
@DynamicUpdate
@Data
public class DepartmentCategory {

   /** 科室id. */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    /** 科室名字. */
    private  String departmentName;

    /** 科室编号. */
    private Integer departmentType;

    private Date createTime;

    private Date updateTime;

    public DepartmentCategory() {
    }

    public DepartmentCategory(String departmentName, Integer departmentType) {
        this.departmentName = departmentName;
        this.departmentType = departmentType;
    }
}
