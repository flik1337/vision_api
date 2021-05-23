package cn.flik1337.vision.dto;

import java.io.Serializable;

/**
 * @Description
 * @Author flik
 * @Date 2020/7/29 20:55
 * @Version 1.0
 */

public class SendSmsDto implements Serializable {
    private static final long serialVersionUID = 68620056131350971L;

    private String mobile;
    private Integer type;  //1--login 2--register

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
