package com.pro1.order.controller;

import com.pro1.order.VO.DepartmentVO;
import com.pro1.order.VO.ResultVO;
import com.pro1.order.dataobject.DepartmentCategory;
import com.pro1.order.service.DepartmentCategoryService;
import com.pro1.order.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentCategoryController {

    @Autowired
    private DepartmentCategoryService departmentCategoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //查询所有科室
        List<DepartmentCategory> departmentCategoryList = departmentCategoryService.findAll();

        //拼装
        List<DepartmentVO> departmentVOList = new ArrayList<>();
        for (DepartmentCategory departmentCategory: departmentCategoryList){
            DepartmentVO departmentVO = new DepartmentVO();
            BeanUtils.copyProperties(departmentCategory, departmentVO);
            departmentVOList.add(departmentVO);
        }

        return ResultVOUtil.success(departmentVOList);
    }
}
