package com.pro1.order.service;

import com.pro1.order.dataobject.DepartmentCategory;

import java.util.List;

public interface DepartmentCategoryService {

    List<DepartmentCategory> findAll();

    List<DepartmentCategory> findByDepartmentNameLike(String departmentName);

}
