package com.pro1.order.controller;

import com.pro1.order.VO.DoctorInfoVO;
import com.pro1.order.VO.ResultVO;
import com.pro1.order.dataobject.DoctorInfo;
import com.pro1.order.service.DoctorInfoService;
import com.pro1.order.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctorInfo")
public class DoctorInfoController {

    @Autowired
    private DoctorInfoService doctorInfoService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "departmentType") Integer type){

        //查询对应科室的所有医生
        List<DoctorInfo> doctorInfoList = doctorInfoService.findByDepartmentType(type);

        //拼装
        List<DoctorInfoVO> doctorInfoVOList = new ArrayList<>();
        for (DoctorInfo doctorInfo: doctorInfoList){
            DoctorInfoVO doctorInfoVO = new DoctorInfoVO();
            BeanUtils.copyProperties(doctorInfo, doctorInfoVO);
            doctorInfoVOList.add(doctorInfoVO);
        }

        return ResultVOUtil.success(doctorInfoVOList);
    }

}
