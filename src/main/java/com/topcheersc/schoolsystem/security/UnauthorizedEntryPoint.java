package com.topcheersc.schoolsystem.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
* @author YX
* @date 2019年11月27日下午2:52:49
* @Description:
*/
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if(isAjaxRequest(request)){
        	//ajax请求，返回401错误
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
        }else{
        	//非ajax请求，重定向到登陆页面
            response.sendRedirect("/schoolsystem/login.html");
        }

    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }

}
