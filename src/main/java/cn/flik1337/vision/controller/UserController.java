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

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SmsService smsService;
    @Autowired
    private UserService userService;
    @Autowired
    private OssService ossService;
    /**
    * @Description: 发送验证码
    * @Param: 
    * @Date: 2021/5/24 10:00:37
    */
    @RequestMapping(value = "sms",method = RequestMethod.POST)
    public CommonResult sendSms(@RequestBody SendSmsDto sendSmsDto){

       smsService.sendSmsCode(sendSmsDto);
       return CommonResult.success();

    }
    
    @RequestMapping(value = "avatar",method = RequestMethod.POST)
    public CommonResult loginByCode(MultipartFile file){
        String newFileName = ossService.uploadSingleFile(file);
        return CommonResult.success(newFileName);



    }
    @RequestMapping(value = "/loginOrRegister",method = RequestMethod.POST)
    public CommonResult loginOrRegister(@RequestBody VerifyCodeDto verifyCodeDto){
        Map<String,Object> userInfo = userService.loginOrRegister(verifyCodeDto);
        return CommonResult.success(userInfo);


    }

}
