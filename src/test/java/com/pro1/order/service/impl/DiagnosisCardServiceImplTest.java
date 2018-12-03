package com.pro1.order.service.impl;

import com.pro1.order.dataobject.DiagnosisCard;
import com.pro1.order.dto.BindInfoDTO;
import com.pro1.order.dto.CardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DiagnosisCardServiceImplTest {

    @Autowired
    private DiagnosisCardServiceImpl diagnosisCardService;

    @Test
    public void findOne() {
        DiagnosisCard diagnosisCard = diagnosisCardService.findOne("00004");
        Assert.assertNotNull(diagnosisCard);
    }

    @Test
    public void create(){

        CardDTO cardDTO = new CardDTO();
        cardDTO.setOpenId("00002");
        cardDTO.setUserEmail("3242224@324.com");
        cardDTO.setUserId("12312312312");
        cardDTO.setUserName("晓张");
        cardDTO.setUserSex("男");

        DiagnosisCard result = diagnosisCardService.create(cardDTO);
        log.info("【创建就诊卡】 result={}", result);
        Assert.assertNotNull(result);

    }

    @Test
    public void bind(){
        BindInfoDTO bindInfoDTO = new BindInfoDTO();
        bindInfoDTO.setOpenId("00004");
        bindInfoDTO.setUserName("小红");
        bindInfoDTO.setUserId("2432423423");
        bindInfoDTO.setUserEmail("242234@asda.com");

        DiagnosisCard result = diagnosisCardService.bind(bindInfoDTO);
        log.info("【绑定就诊卡】 result={}", result);
        Assert.assertNotNull(result);
    }
}