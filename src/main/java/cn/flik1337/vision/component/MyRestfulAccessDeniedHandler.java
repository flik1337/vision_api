package cn.flik1337.vision.component;

import cn.flik1337.vision.common.api.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Documented;

/**
 * 当访问接口没有权限时，自定义的返回结果
 * Created by flik on 2020/7/27.
 */
@Component
public class MyRestfulAccessDeniedHandler implements AccessDeniedHandler{
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(objectMapper.writeValueAsString(CommonResult.forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
