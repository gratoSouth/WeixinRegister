package com.pro1.order.repository;

import com.pro1.order.dataobject.DepartmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentCategoryRepository extends JpaRepository<DepartmentCategory, Integer> {

    List<DepartmentCategory> findByDepartmentNameLike(String departmentName);

    DepartmentCategory findByDepartmentType(Integer departmentType);
}

