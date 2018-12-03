package com.pro1.order.converter;

import com.pro1.order.dto.BindInfoDTO;
import com.pro1.order.form.BindInfoForm;

public class BindInfoForm2BindInfoDTO {

    public static BindInfoDTO convert(BindInfoForm bindInfoForm){
        BindInfoDTO bindInfoDTO = new BindInfoDTO();
        bindInfoDTO.setOpenId(bindInfoForm.getOpenid());
        bindInfoDTO.setUserName(bindInfoForm.getUsername());
        bindInfoDTO.setUserId(bindInfoForm.getUserid());
        bindInfoDTO.setUserEmail(bindInfoForm.getUseremail());

        return bindInfoDTO;
    }
}
