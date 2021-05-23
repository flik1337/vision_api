package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.dto.SendSmsDto;
import cn.flik1337.vision.dto.VerifyCodeDto;
import cn.flik1337.vision.service.OssService;
import cn.flik1337.vision.service.SmsService;
import cn.flik1337.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SmsService smsService;
    @Autowired
    private UserService userService;
    @Autowired
    private OssService ossService;

    @RequestMapping(value = "sms",method = RequestMethod.POST)
    public CommonResult sendSms(@RequestBody SendSmsDto sendSmsDto){

       return smsService.sendSmsCode(sendSmsDto);

    }

    @RequestMapping(value = "login/sms",method = RequestMethod.GET)
    public CommonResult loginByCode(@ModelAttribute VerifyCodeDto verifyCodeDto){

        return userService.loginByCode(verifyCodeDto);

    }
    @RequestMapping(value = "avatar",method = RequestMethod.POST)
    public CommonResult loginByCode(MultipartFile file){

        return ossService.uploadSingleFile(file);

    }
    @RequestMapping(value = "/loginOrRegister",method = RequestMethod.POST)
    public CommonResult loginOrRegister(@RequestBody VerifyCodeDto verifyCodeDto){
        return userService.loginOrRegister(verifyCodeDto);
    }

}
