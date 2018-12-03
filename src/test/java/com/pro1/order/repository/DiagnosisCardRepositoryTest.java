package com.pro1.order.repository;

import com.pro1.order.dataobject.DiagnosisCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiagnosisCardRepositoryTest {

    @Autowired
    private DiagnosisCardRepository repository;

    @Test
    public void saveTest(){
        DiagnosisCard diagnosisCard = new DiagnosisCard();
        diagnosisCard.setDiagnosiscardId("00001");
        diagnosisCard.setUserName("小张");
        diagnosisCard.setUserSex("男");
        diagnosisCard.setUserEmail("23232323@sds.com");
        diagnosisCard.setUserId("53422423423422");
        diagnosisCard.setAccountBalance(new BigDecimal(100));

        DiagnosisCard result = repository.save(diagnosisCard);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserIdTest(){
        DiagnosisCard diagnosisCard = repository.findByUserId("53422423423422");
        Assert.assertNotNull(diagnosisCard);
    }
}