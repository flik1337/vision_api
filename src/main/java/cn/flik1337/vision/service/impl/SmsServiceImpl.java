package cn.flik1337.vision.service.impl;


import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.api.ResultCode;
import cn.flik1337.vision.common.constant.SmsConstants;
import cn.flik1337.vision.common.exception.Asserts;
import cn.flik1337.vision.common.utils.SmsUtil;
import cn.flik1337.vision.dto.SendSmsDto;
import cn.flik1337.vision.dto.VerifyCodeDto;
import cn.flik1337.vision.service.RedisService;
import cn.flik1337.vision.service.SmsService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static cn.flik1337.vision.common.api.ResultCode.BODY_NOT_MATCH;
import static cn.flik1337.vision.common.api.ResultCode.CODE_TOO_SOON;


/**
 * @Description
 * @Author flik
 * @Date 2020/7/30 0:00
 * @Version 1.0
 */
@Service
@Transactional
public class SmsServiceImpl implements SmsService {

    private ResultCode resultCode;
    /*@Resource
    private SmsSingleSender smsSingleSender;*/

//    @Autowired
//    private UserCacheService userCacheService;

    @Autowired
    private RedisService redisService;


    private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);


    /**
     * 短信签名内容
     */
    @Value("${smsconfig.smsSign}")
    private String SMS_SIGN;

    @Value("${smsconfig.invalidtime}")
    private String INVALID_TIME;

    @Value("${smsconfig.phone-prefix}")
    private String PHONE_PREFIX;

    @Value("${smsconfig.appId}")
    private int APP_ID;

    @Value("${smsconfig.templateid}")
    private Integer TEMPLATE_ID;

    @Value("${smsconfig.appkey}")
    private String APP_KEY;




    /* form user service*/
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    private final static String NATION_CODE = "86";
    private final static String DURATION = "10";


    @Override
    public CommonResult sendSmsCode(SendSmsDto sendSmsDto) {

        String code = SmsUtil.getCode();
        Integer templateId = TEMPLATE_ID;
        Integer type = sendSmsDto.getType();
        if(templateId == null){

            return CommonResult.failed(resultCode.BODY_NOT_MATCH);
        }
        try {
            String[] params = {code,DURATION};

            SmsSingleSenderResult senderResult = new SmsSingleSender(APP_ID,APP_KEY)
                    .sendWithParam(NATION_CODE, sendSmsDto.getMobile(),
                            templateId, params, SMS_SIGN, "", "");
            int statusCode = senderResult.result;
            String statusMsg = senderResult.errMsg;

            // 过于频繁
            if (SmsConstants.SEND_SMS_CODE_FREQUENT == statusCode) {

                Asserts.fail(resultCode.CODE_TOO_SOON);
            }
            // 达到上限
            if (SmsConstants.SEND_SMS_CODE_UPPER == statusCode) {

                Asserts.fail(resultCode.CODE_TOO_MANY);
            }


            // 储存验证码至redis
            redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + sendSmsDto.getMobile(), code);
            redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + sendSmsDto.getMobile(), AUTH_CODE_EXPIRE_SECONDS);

        } catch (Exception e) {
            LOGGER.warn("发送异常:{}", e.getMessage());

        }
        return CommonResult.success();
    }




    @Override
    public boolean verifyCode(VerifyCodeDto verifyCodeDto) {

        String authCode = verifyCodeDto.getCode();
        String phone = verifyCodeDto.getMobile();
        Integer type = verifyCodeDto.getType();
        System.out.println("autoCode == "+authCode);
        System.out.println("phone == "+phone);
        if(StringUtils.isEmpty(authCode)){
            return false;
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + verifyCodeDto.getMobile());;
        // 保证验证码有效次数为1次
        return authCode.equals(realAuthCode);
    }








}
