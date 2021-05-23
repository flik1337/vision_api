package cn.flik1337.vision.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 读取secure.ignored 获取忽略的路径
 * @Author flik
 * @Date 2020/7/28 19:05
 * @Version 1.0
 */


@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
