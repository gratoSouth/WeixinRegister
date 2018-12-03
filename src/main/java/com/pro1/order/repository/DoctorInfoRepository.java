package com.pro1.order.repository;

import com.pro1.order.dataobject.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorInfoRepository extends JpaRepository<DoctorInfo, Integer> {

    List<DoctorInfo> findByDepartmentType(Integer departmentType);

    List<DoctorInfo> findByDoctorNameLike(String doctorName);
}
