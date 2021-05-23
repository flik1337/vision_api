package cn.flik1337.vision.common.utils;

import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Component;

@Component
public class RandomsUtil {
    public static String USERNAME_PREFIX = "用户";
    public static String getRandomUserName(){
        String randomNo = RandomUtil.randomString(6);
        String userName = USERNAME_PREFIX + randomNo;
        System.out.println("生成的随机名称为"+userName);
        return userName;
    }

}
