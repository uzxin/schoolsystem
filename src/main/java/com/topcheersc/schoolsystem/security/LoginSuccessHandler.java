package com.topcheersc.schoolsystem.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.topcheersc.schoolsystem.utils.HTTPUtils;

/**
* @author YX
* @date 2019年11月27日下午1:55:27
* @Description:登陆成功处理器
*/
@Component("LoginSuccessHandler")
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
    private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		if (HTTPUtils.isAjaxRequest(request)) {
			logger.info("登录成功");
			// 获取缓存
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			//准备json
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", "success");
			jsonObject.put("msg", "登录成功");
	        // 缓存非空判断
	        if (savedRequest != null) {
	            // 跳转到之前引发跳转的url
	            String url = savedRequest.getRedirectUrl();
	    		jsonObject.put("url", url);
	        }
	        response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonObject.toString());
		}else {
			//非ajax请求，直接调用默认的处理方法
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

	
}
