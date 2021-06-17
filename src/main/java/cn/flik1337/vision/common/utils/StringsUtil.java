package cn.flik1337.vision.common.utils;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public  class StringsUtil {

    @Autowired
    private static ObjectMapper objectMapper;

    public  boolean hasEmpty(String strs){
        return StrUtil.hasEmpty(strs);
    }

    public static String ObjToJson(Object obj){
        String jsonStr = null;
        try {
            jsonStr =  objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
