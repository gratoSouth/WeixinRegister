package com.pro1.order.converter;

import com.pro1.order.dto.OrderDTO;
import com.pro1.order.form.OrderForm;

public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOpenId(orderForm.getOpenid());
        orderDTO.setScheduleId(orderForm.getScheduleid());

        return orderDTO;
    }
}
