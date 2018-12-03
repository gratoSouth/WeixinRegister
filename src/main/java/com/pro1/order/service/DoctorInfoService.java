package com.pro1.order.service;

import com.pro1.order.dataobject.DoctorInfo;

import java.util.List;

public interface DoctorInfoService {

    List<DoctorInfo> findByDepartmentType(Integer departmentType);

    List<DoctorInfo> findByDoctorNameLike(String doctorName);
}
