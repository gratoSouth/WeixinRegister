package com.pro1.order.controller;

import com.pro1.order.VO.ResultVO;
import com.pro1.order.VO.ScheduleVO;
import com.pro1.order.dataobject.Schedule;
import com.pro1.order.service.ScheduleService;
import com.pro1.order.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "doctorId") Integer doctorId){

        //查询
        List<Schedule> scheduleList = scheduleService.findByDoctorId(doctorId);

        //拼装
        List<ScheduleVO> scheduleVOList = new ArrayList<>();
        for (Schedule schedule: scheduleList){
            ScheduleVO scheduleVO = new ScheduleVO();
            BeanUtils.copyProperties(schedule, scheduleVO);
            scheduleVOList.add(scheduleVO);
        }

        return ResultVOUtil.success(scheduleVOList);
    }

}
