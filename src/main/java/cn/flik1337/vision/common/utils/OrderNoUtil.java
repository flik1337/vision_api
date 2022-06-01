package cn.flik1337.vision.common.utils;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生成逻辑 ： 下单渠道+业务类型+时间信息+自增
 *  时间信息：当前时间戳（13位）/1000，去除第一位
* @Description: 电影订单生成工具
* @Param:
* @Date: 2021/6/2 11:32:27
*/
@Component
public class OrderNoUtil {
    @Autowired
    private StringRedisTemplate autowireRedisTemplate;

    private static RedisTemplate redisTemplate;

    private static final int APP_IDENTIFY = 3;

    private static final String CHANNEL = "1"; // 下单渠道 1小程序 2网页
    private static final String BUSINESS_TYPE = "1"; //业务类型 1订单


    @PostConstruct
    public void init() {
        redisTemplate = autowireRedisTemplate;
    }

    public static String createBookingOrderNo() {
        StringBuilder OrderNo = new StringBuilder();
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("order_id", redisTemplate.getConnectionFactory());
        Long currentValue = redisAtomicLong.get();
        if (currentValue == 0) {
            redisAtomicLong.set(111L);
        }
        // 自增 ，并获取自增值，每1000进行循环
        Long incrementValue = redisAtomicLong.incrementAndGet() % 1000;


        OrderNo.append(CHANNEL).append(BUSINESS_TYPE).append((System.currentTimeMillis() / 1000 + "").substring(1)).append(incrementValue);
        //System.out.println(OrderNo);
        return OrderNo.toString();
    }

    public static String generateAuthCode(String orderNo){
        String random = RandomUtil.randomNumbers(1);
        String prefix = orderNo.substring(0,orderNo.length()/2);
        String suffix = orderNo.substring(orderNo.length()/2);

        StringBuilder code = new StringBuilder();
        code.append(suffix).append(APP_IDENTIFY).append(random).append(prefix);
        System.out.println(code.toString());
        return code.toString();
    }

    public static String authCode(String code){
         int orderNoLength = code.length() -2;  // 14
         String prefix = code.substring(orderNoLength /2 + 2);
         String suffix = code.substring(0,orderNoLength /2 );
         StringBuilder orderNo = new StringBuilder();
         orderNo.append(prefix).append(suffix);
        System.out.println(orderNo.toString());
         return orderNo.toString();
    }

    public static void main(String[] args) {
        authCode("7277128321162297");
    }



}
