package com.pro1.order.controller;

import com.pro1.order.VO.ResultVO;
import com.pro1.order.converter.OrderForm2OrderDTO;
import com.pro1.order.dataobject.OrderDetail;
import com.pro1.order.dto.OrderDTO;
import com.pro1.order.enums.ResultEnum;
import com.pro1.order.exception.OrderException;
import com.pro1.order.form.OrderForm;
import com.pro1.order.service.OrderService;
import com.pro1.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    //创建预约表
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建预约表】参数不正确， orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        OrderDetail createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderNumber", createResult.getOrderNumber().toString());

        return ResultVOUtil.success(map);
    }

    //预约列表
    @GetMapping("/list")
    public ResultVO<List<OrderDetail>> list(@RequestParam("openid") String openid){

        if (StringUtils.isEmpty(openid)){
            log.error("【查询预约列表】 openid为空");
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        List<OrderDetail> orderDetailList = orderService.findList(openid);

        return ResultVOUtil.success(orderDetailList);
    }
}
