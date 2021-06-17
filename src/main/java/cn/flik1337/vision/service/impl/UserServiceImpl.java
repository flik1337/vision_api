package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.api.ResultCode;
import cn.flik1337.vision.common.exception.ApiException;
import cn.flik1337.vision.common.exception.Asserts;
import cn.flik1337.vision.common.utils.JwtTokenUtil;
import cn.flik1337.vision.common.utils.RandomsUtil;
import cn.flik1337.vision.domain.FUserDetails;
import cn.flik1337.vision.dto.VerifyCodeDto;
import cn.flik1337.vision.mbg.mapper.UserMapper;
import cn.flik1337.vision.mbg.model.User;
import cn.flik1337.vision.mbg.model.UserExample;
import cn.flik1337.vision.service.SmsService;
import cn.flik1337.vision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.flik1337.vision.common.api.ResultCode.*;
import static cn.flik1337.vision.common.constant.UserConstants.DEFAULT_AVATAR_NAME;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SmsService smsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RandomsUtil randomsUtil;

    @Override
    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUserByPhone(String phone){
        User user = null;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andTelephoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    /**
    * @Description: 从当前缓存中获取用户
    * @Param: 
    * @Date: 2021/5/19 08:34:16
    */
    @Override
    public User getCurrentUser() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        FUserDetails userDetails = (FUserDetails) auth.getPrincipal();
        return userDetails.getUser();
    }

    
    @Override
    public UserDetails loadUserByUsername(int userId) {

        User user = userMapper.selectByPrimaryKey(Integer.parseInt(String.valueOf(userId)));

        if(user!=null){
            return new FUserDetails(user);
        }
        throw new ApiException(USER_NOT_EXIST);
    }


    @Override
    public Map<String,Object> loginOrRegister(VerifyCodeDto params){
        // 检查该手机号是否存在
        List<User> users = getUserByPhone(params.getMobile());
        if (users.size() == 0){
            // 不存在 注册为新用户
            return register(params);
        }else{
            // 存在，登陆
            return loginByCode(params,users.get(0));
        }
    }

    /**
    * @Description: 验证码登陆
    * @Param: 
    * @Date: 2021/5/19 08:37:11
    */
    @Override
    public Map<String,Object> loginByCode(VerifyCodeDto params,User currentUser){
        // 校验登陆池中的验证码
        boolean isCodeCorrect = smsService.verifyCode(params);
        if (isCodeCorrect){

            // 若校验通过，则构造map，存放token和用户信息
            Map<String,Object> userInfoMap = generateUserInfo(currentUser);
            return userInfoMap;
        }else{
            Asserts.fail(WRONG_CODE);
            return null;
        }


    }
    /**
    * @Description: 生成用户的信息 包括token 等级等资料
    * @Param:
    * @Date: 2021/5/23 10:02:02
    */
    @Override
    public Map<String,Object> generateUserInfo(User user){
        // 生成token
        String token  = jwtTokenUtil.generateToken(jwtTokenUtil.generateUserDetails(user));
        Map<String,Object> userInfoMap = new HashMap<String, Object>();
        userInfoMap.put("userInfo",user);
        userInfoMap.put("token",token);
        // todo 生成等级信息

        return userInfoMap;
    }

    /**
    * @Description: 初始化用户信息
    * @Param: 
    * @Date: 2021/5/23 09:28:13
    */
    @Override
    public User initUserProfile(String phone){
        
        User user = new User();
        user.setTelephone(phone);
        user.setUserName(randomsUtil.getRandomUserName());
        user.setAvatar(DEFAULT_AVATAR_NAME);
        user.setGender(1);
        user.setPwd("");
        user.setUserExp(0);
        
        return user;
    }


    @Override
    public Map<String,Object> register(VerifyCodeDto params){

        boolean isCodeCorrect = smsService.verifyCode(params);
        if (isCodeCorrect){
            User user = initUserProfile(params.getMobile());
            int userId = userMapper.insert(user);

            if (userId ==  0){
                //插入失败
                Asserts.fail(FAIL_UPDATE_USER);
                return null;
            }
            // 插入成功后,设置用户id
            user.setUserId(userId);
            // 构造用户信息
            Map<String,Object> userMap = generateUserInfo(user);
            return userMap;

        }

        return null;
    }



}
