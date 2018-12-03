package com.pro1.order.service.impl;

import com.pro1.order.dataobject.*;
import com.pro1.order.dto.OrderDTO;
import com.pro1.order.enums.ResultEnum;
import com.pro1.order.exception.OrderException;
import com.pro1.order.repository.DepartmentCategoryRepository;
import com.pro1.order.repository.DoctorInfoRepository;
import com.pro1.order.repository.OrderDetailRepository;
import com.pro1.order.repository.UserInfoRepository;
import com.pro1.order.service.OrderService;
import com.pro1.order.utils.KeyUtil;
import com.pro1.order.utils.OrderNumberUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private DoctorInfoRepository doctorInfoRepository;

    @Autowired
    private DepartmentCategoryRepository departmentCategoryRepository;

    @Autowired
    private DiagnosisCardServiceImpl diagnosisCardService;

    @Override
    @Transactional
    public OrderDetail create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        //1. 查询日程表（挂号数量、费用）
        Schedule schedule = scheduleService.findOne(orderDTO.getScheduleId());
        if(schedule == null){
            throw new OrderException(ResultEnum.SCHEDULE_NOT_EXIST);
        }

        //2. 查询用户绑定表
        UserInfo userInfo = userInfoRepository.findById(orderDTO.getOpenId()).orElse(null);
        if(userInfo == null){
            throw new OrderException(ResultEnum.USERINFO_NOT_EXIST);
        }
        if(userInfo.getDiagnosiscardId() == null){
            throw new OrderException(ResultEnum.UNBOUND);
        }

        //获取对应医生信息
        DoctorInfo doctorInfo = doctorInfoRepository.findById(schedule.getDoctorId()).orElse(null);
        //获取对应科室信息
        DepartmentCategory departmentCategory = departmentCategoryRepository.findByDepartmentType(doctorInfo.getDepartmentType());

        //3. 写入预约表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDiagnosiscardId(userInfo.getDiagnosiscardId());
        orderDetail.setOrderId(orderId);
        orderDetail.setScheduleId(schedule.getScheduleId());
        orderDetail.setDoctorName(doctorInfo.getDoctorName());
        orderDetail.setDepartmentName(departmentCategory.getDepartmentName());
        orderDetail.setOrderNumber(OrderNumberUtil.orderNumber(schedule));
        BeanUtils.copyProperties(schedule, orderDetail);
        orderDetailRepository.save(orderDetail);

        //4. 扣除费用
        diagnosisCardService.deductMoney(userInfo.getDiagnosiscardId(), schedule.getOrderFee());

        //5. 扣除挂号剩余数量
        scheduleService.decreaseStock(schedule.getScheduleId());

        return orderDetail;
    }

    @Override
    public List<OrderDetail> findList(String userOpenid) {

        //查询用户绑定表
        UserInfo userInfo = userInfoRepository.findById(userOpenid).orElse(null);
        if(userInfo == null){
            throw new OrderException(ResultEnum.USERINFO_NOT_EXIST);
        }
        if(userInfo.getDiagnosiscardId() == null){
            throw new OrderException(ResultEnum.UNBOUND);
        }
        return orderDetailRepository.findByDiagnosiscardId(userInfo.getDiagnosiscardId());
    }
}
