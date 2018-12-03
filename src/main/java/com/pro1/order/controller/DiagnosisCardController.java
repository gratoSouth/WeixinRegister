package com.pro1.order.controller;

import com.pro1.order.VO.ResultVO;
import com.pro1.order.converter.BindInfoForm2BindInfoDTO;
import com.pro1.order.converter.CardForm2CardDTO;
import com.pro1.order.dataobject.DiagnosisCard;
import com.pro1.order.dto.BindInfoDTO;
import com.pro1.order.dto.CardDTO;
import com.pro1.order.enums.ResultEnum;
import com.pro1.order.exception.OrderException;
import com.pro1.order.form.BindInfoForm;
import com.pro1.order.form.CardForm;
import com.pro1.order.service.DiagnosisCardService;
import com.pro1.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/diagnosiscard")
@Slf4j
public class DiagnosisCardController {

    @Autowired
    private DiagnosisCardService diagnosisCardService;

    //创建就诊卡
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid CardForm cardForm,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建就诊卡】参数不正确， cardForm={}", cardForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        CardDTO cardDTO = CardForm2CardDTO.convert(cardForm);
        DiagnosisCard createResult = diagnosisCardService.create(cardDTO);

        Map<String, String> map = new HashMap<>();
        map.put("diagnosiscardId", createResult.getDiagnosiscardId());

        return ResultVOUtil.success(map);
    }

    //绑定就诊卡
    @PostMapping("/bind")
    public ResultVO<Map<String, String>> bind(@Valid BindInfoForm bindInfoForm,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("【绑定就诊卡】参数不正确， bindInfoForm={}", bindInfoForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        BindInfoDTO bindInfoDTO = BindInfoForm2BindInfoDTO.convert(bindInfoForm);
        DiagnosisCard bindResult = diagnosisCardService.bind(bindInfoDTO);

        Map<String, String> map = new HashMap<>();
        map.put("diagnosiscardId", bindResult.getDiagnosiscardId());

        return ResultVOUtil.success(map);
    }

    //用户个人信息
    @GetMapping("/userinfo")
    public ResultVO<DiagnosisCard> userInfo(@RequestParam("openid") String openid){

        if (StringUtils.isEmpty(openid)){
            log.error("【查询预约列表】 openid为空");
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        DiagnosisCard diagnosisCard = diagnosisCardService.findOne(openid);

        return ResultVOUtil.success(diagnosisCard);
    }
}
