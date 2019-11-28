package com.topcheersc.schoolsystem.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
* @author YX
* @date 2019年11月27日上午9:11:28
* @Description:
*/
@RestController
public class LoginController {

	/**
     * 
     * @Description:从session中获取用户信息
     * @param 
     * @return void
     */
	 @RequestMapping("/getUser")
	public String getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			User user = (User) auth.getPrincipal();
			return("当前用户："+auth.getName()+"权限："+user.getAuthorities());
		}
		return null;
	}
}
