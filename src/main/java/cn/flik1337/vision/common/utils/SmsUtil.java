package cn.flik1337.vision.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Random;

/**
 * @Description
 * @Author flik
 * @Date 2021/5/18 0:18
 * @Version 1.1
 */
@Configuration
public class SmsUtil {
    @Value("${smsconfig.phone-prefix}")
    private String PHONE_PREFIX;

    public static HashMap<Integer, String> map = new HashMap<>();

    @Bean
    public void getPhonePrefix() {
        String[] prefixArray = PHONE_PREFIX.split(",");
        for (int i = 0, j = 1; i < prefixArray.length; i++, j++) {
            map.put(j, prefixArray[i]);
        }
    }


    /**
     * 获取验证码 返回4位随机数字
     *
     * @return
     */
    public static String getCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
/*        Random rd = new Random();
        String n = "";
        int getNum;
        do {
            // 产生数字0-9的随机数
            getNum = Math.abs(rd.nextInt()) % 10 + 48;
            // getNum = Math.abs(rd.nextInt())%26 + 97;//产生字母a-z的随机数
            char num1 = (char) getNum;
            String dn = Character.toString(num1);
            n += dn;
        } while (n.length() < 4);
        return n;*/
    }

}
