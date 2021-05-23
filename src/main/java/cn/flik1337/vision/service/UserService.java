package cn.flik1337.vision.service;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.dto.VerifyCodeDto;
import cn.flik1337.vision.mbg.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User getUserById(int id);
    public UserDetails loadUserByUsername(int param);
    public CommonResult loginByCode(VerifyCodeDto param);
    public User getCurrentUser();
    public Map<String,Object> generateUserInfo(User user);
    public User initUserProfile(String phone);
    public CommonResult register(VerifyCodeDto params);
    public CommonResult loginOrRegister(VerifyCodeDto params);
    public List<User> getUserByPhone(String phone);
}
