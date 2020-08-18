package com.springsecurity.springsecurity2.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName MyfailureHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/18 14:21
 * @Version 1.0
 */
@Component
public class MyfailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyfailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        /* 默认：执行重定向或转发到defaultfailureurl(如果设置)，Otherw返回401错误代码 */
        //super.onAuthenticationFailure(request,response,exception)
        LOGGER.error("登录错误 [{}] ",exception.getMessage());
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(exception.getMessage());
        System.out.println("登陆失败");
        writer.flush();
        writer.close();
    }
}
