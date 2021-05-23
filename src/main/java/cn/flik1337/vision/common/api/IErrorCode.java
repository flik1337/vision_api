package cn.flik1337.vision.common.api;

import lombok.Getter;

/**
 * 封装API的错误码
 * Created by macro on 2019/4/19.
 */

public interface IErrorCode {

    long getCode();

    String getMessage();
}
