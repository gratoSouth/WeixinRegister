package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DepartmentCategory;
import com.pro1.order.repository.DepartmentCategoryRepository;
import com.pro1.order.service.DepartmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentCategoryServiceImpl implements DepartmentCategoryService {

    @Autowired
    private DepartmentCategoryRepository repository;

    @Override
    public List<DepartmentCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DepartmentCategory> findByDepartmentNameLike(String departmentName) {
        return repository.findByDepartmentNameLike("%"+departmentName+"%");
    }
}
