package com.topcheersc.schoolsystem.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.topcheersc.schoolsystem.utils.HTTPUtils;

/**
* @author YX
* @date 2019年11月27日下午1:58:35
* @Description:自定义登陆失败处理器
*/
@Component("LoginFailureHandler")
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.info("登录失败");
		if (HTTPUtils.isAjaxRequest(request)) {
			// 如果是ajax请求，就返回一个json
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", "flase");
			jsonObject.put("msg", "登录失败，请检查用户名和密码是否正确");
	        response.setContentType("application/json;charset=UTF-8");
	        response.getWriter().write(jsonObject.toString());
		}else {
			// 如果是fomr表单提交就重定向到登陆页面
			response.sendRedirect("/schoolsystem/login.html?error=true");
		}
	}
	
	
}
