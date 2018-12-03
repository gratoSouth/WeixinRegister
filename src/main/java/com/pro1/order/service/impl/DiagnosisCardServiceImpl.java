package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DiagnosisCard;
import com.pro1.order.dataobject.UserInfo;
import com.pro1.order.dto.BindInfoDTO;
import com.pro1.order.dto.CardDTO;
import com.pro1.order.enums.ResultEnum;
import com.pro1.order.exception.OrderException;
import com.pro1.order.repository.DiagnosisCardRepository;
import com.pro1.order.repository.UserInfoRepository;
import com.pro1.order.service.DiagnosisCardService;
import com.pro1.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class DiagnosisCardServiceImpl implements DiagnosisCardService {

    @Autowired
    private DiagnosisCardRepository diagnosisCardRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public DiagnosisCard findOne(String openId) {
        UserInfo userInfo = userInfoRepository.findById(openId).orElse(null);
        if(userInfo == null){
            throw new OrderException(ResultEnum.USERINFO_NOT_EXIST);
        }
        if(userInfo.getDiagnosiscardId() == null){
            throw new OrderException(ResultEnum.UNBOUND);
        }
        return diagnosisCardRepository.findById(userInfo.getDiagnosiscardId()).orElse(null);
    }

    @Override
    @Transactional
    public void deductMoney(String diagnosiscardId, BigDecimal orderFee) {

        BigDecimal restMoney = new BigDecimal(BigInteger.ZERO);

        DiagnosisCard diagnosisCard = diagnosisCardRepository.findById(diagnosiscardId).orElse(null);
        if (diagnosisCard == null){
            throw new  OrderException(ResultEnum.DIAGNOSISCARD_NOT_EXIST);
        }
        restMoney = diagnosisCard.getAccountBalance().subtract(orderFee);
        Integer temp = restMoney.compareTo(BigDecimal.ZERO);

        if (temp == -1){
            throw new OrderException(ResultEnum.INSUFFICIENT_ACCOUNT_BALANCE);
        }
        diagnosisCard.setAccountBalance(restMoney);

        diagnosisCardRepository.save(diagnosisCard);
    }

    @Override
    @Transactional
    public DiagnosisCard create(CardDTO cardDTO) {

        String diagnosiscardId = KeyUtil.genUniqueKey();

        //1.创建就诊卡
        DiagnosisCard diagnosisCard = new DiagnosisCard();
        diagnosisCard.setDiagnosiscardId(diagnosiscardId);
        diagnosisCard.setAccountBalance(BigDecimal.ZERO);
        BeanUtils.copyProperties(cardDTO, diagnosisCard);
        DiagnosisCard createResult = diagnosisCardRepository.save(diagnosisCard);

        //2.自动绑定创建的就诊卡
        UserInfo userInfo = userInfoRepository.findById(cardDTO.getOpenId()).orElse(null);
        if(userInfo == null){
            throw new OrderException(ResultEnum.USERINFO_NOT_EXIST);
        }
        userInfo.setDiagnosiscardId(createResult.getDiagnosiscardId());
        userInfoRepository.save(userInfo);

        return diagnosisCard;
    }

    @Override
    public DiagnosisCard bind(BindInfoDTO bindInfoDTO) {

        //查询就诊卡信息
        DiagnosisCard diagnosisCard = diagnosisCardRepository.findByUserId(bindInfoDTO.getUserId());
        if (diagnosisCard == null){
            throw new OrderException(ResultEnum.DIAGNOSISCARD_NOT_EXIST);
        }
        if (!( bindInfoDTO.getUserName().equals(diagnosisCard.getUserName()) || bindInfoDTO.getUserEmail().equals(diagnosisCard.getUserEmail()))){
            throw new OrderException(ResultEnum.USERINFO_ERROR);
        }

        //查询用户绑定表
        UserInfo userInfo = userInfoRepository.findById(bindInfoDTO.getOpenId()).orElse(null);
        if(userInfo == null){
            throw new OrderException(ResultEnum.USERINFO_NOT_EXIST);
        }

        //绑定信息
        userInfo.setDiagnosiscardId(diagnosisCard.getDiagnosiscardId());
        userInfoRepository.save(userInfo);

        return diagnosisCard;
    }
}
