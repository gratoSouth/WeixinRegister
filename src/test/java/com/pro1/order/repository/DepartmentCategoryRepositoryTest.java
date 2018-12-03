package com.pro1.order.repository;

import com.pro1.order.dataobject.DepartmentCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentCategoryRepositoryTest {
    @Autowired
    private DepartmentCategoryRepository repository;

    @Test
    public void findOneTest(){
        DepartmentCategory departmentCategory = repository.findById(1).orElse(null);
        System.out.println(departmentCategory.toString());
    }

    @Test
    public void saveTest(){
        DepartmentCategory departmentCategory = new DepartmentCategory("儿科", 3);
        repository.save(departmentCategory);
    }

    @Test
    @Transactional
    public void updateTest(){
        DepartmentCategory departmentCategory = new DepartmentCategory("外科", 3);
        DepartmentCategory result = repository.save(departmentCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByDepartmentNameLikeTest(){
        List<DepartmentCategory> departmentCategoryList = repository.findByDepartmentNameLike("%"+"外"+"%");
        Assert.assertNotEquals(0, departmentCategoryList.size());
    }

    @Test
    public void findByDepartmentTypeTest(){
        DepartmentCategory departmentCategory = repository.findByDepartmentType(1);
        Assert.assertNotNull(departmentCategory);
    }
}