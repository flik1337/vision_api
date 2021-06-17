package cn.flik1337.vision.service;


import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.dto.SendSmsDto;
import cn.flik1337.vision.dto.VerifyCodeDto;

public interface SmsService {
    void sendSmsCode(SendSmsDto sendSmsDto);

    boolean verifyCode(VerifyCodeDto verifyCodeDto);
}
