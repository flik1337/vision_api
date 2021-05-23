package cn.flik1337.vision.dto;

import java.io.Serializable;

/**
 * @Description
 * @Author flik
 * @Date 2020/7/29 20:56
 * @Version 1.0
 */

public class VerifyCodeDto implements Serializable {
    private static final long serialVersionUID = -930643320039975742L;

    private String mobile;
    private String code;
    private int type; // 0 -> login 1->register

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
