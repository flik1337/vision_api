package cn.flik1337.vision.controller;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.utils.JwtTokenUtil;
import cn.flik1337.vision.domain.FUserDetails;
import cn.flik1337.vision.mbg.model.User;
import cn.flik1337.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    @GetMapping("test")
    public CommonResult test(){
        //@RequestParam int id
//        User user = userService.getUserById(id);
//        System.out.println(user.toString());
//        FUserDetails fUserDetails = jwtTokenUtil.generateUserDetails(user);
//        System.out.println(fUserDetails.toString());
//        String token  =  jwtTokenUtil.generateToken(fUserDetails);
//        System.out.println(token);
        System.out.println("111");
        return CommonResult.success();
    }


}
