package com.pro1.order.service;

import com.pro1.order.dataobject.DiagnosisCard;
import com.pro1.order.dto.BindInfoDTO;
import com.pro1.order.dto.CardDTO;

import java.math.BigDecimal;

public interface DiagnosisCardService {

    DiagnosisCard findOne(String openId);

    //付费操作
    void deductMoney(String diagnosiscardId, BigDecimal orderFee);

    //创建就诊卡
    DiagnosisCard create(CardDTO cardDTO);

    //绑定就诊卡
    DiagnosisCard bind(BindInfoDTO bindInfoDTO);
}
