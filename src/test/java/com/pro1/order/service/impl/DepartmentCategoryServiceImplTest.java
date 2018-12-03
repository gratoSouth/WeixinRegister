package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DepartmentCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentCategoryServiceImplTest {

    @Autowired
    private DepartmentCategoryServiceImpl departmentCategoryService;

    @Test
    public void findAll() {
        List<DepartmentCategory> departmentCategoryList = departmentCategoryService.findAll();
        Assert.assertNotEquals(0, departmentCategoryList.size());
    }

    @Test
    public void findByDepartmentNameLike(){
        List<DepartmentCategory> departmentCategoryList = departmentCategoryService.findByDepartmentNameLike("外");
        Assert.assertNotEquals(0,departmentCategoryList.size());
    }
}