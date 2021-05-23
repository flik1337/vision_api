package cn.flik1337.vision.common.exception;




import cn.flik1337.vision.common.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.flik1337.vision.common.api.ResultCode.BODY_NOT_MATCH;
import static cn.flik1337.vision.common.api.ResultCode.FAILED;

/**
 * @Description 全局异常处理
 * @Author flik
 * @Date 2020/7/31 16:38
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult apiExceptionHandle(ApiException e){
        System.out.println(e.toString());
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public CommonResult npExceptionHandle(NullPointerException e){
        e.printStackTrace();
        return CommonResult.failed(BODY_NOT_MATCH);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult handle(Exception e){
        System.out.println(e.toString());
        return CommonResult.failed(FAILED);
    }
}
