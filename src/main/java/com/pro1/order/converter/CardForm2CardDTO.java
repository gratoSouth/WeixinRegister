package com.pro1.order.converter;

import com.pro1.order.dto.CardDTO;
import com.pro1.order.form.CardForm;

public class CardForm2CardDTO {

    public static CardDTO convert(CardForm cardForm){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setOpenId(cardForm.getOpenid());
        cardDTO.setUserName(cardForm.getUsername());
        cardDTO.setUserId(cardForm.getUserid());
        cardDTO.setUserSex(cardForm.getUsersex());
        cardDTO.setUserEmail(cardForm.getUseremail());

        return cardDTO;
    }
}
