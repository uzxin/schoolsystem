package com.topcheersc.schoolsystem.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.topcheersc.schoolsystem.mapper.SecurityMapper;
import com.topcheersc.schoolsystem.pojo.SecurityUser;

/**
* @author YX
* @date 2019年11月27日上午10:46:25
* @Description:
*/
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private SecurityMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = mapper.getUserByUserName(username);
        if (user == null) {
            throw new BadCredentialsException(username+"not found");
        }
		return new User(username, user.getPassword(), getAuthorities(username));
	}

	/*
	 * 为用户设置角色，一般从数据库获取
	 */
	private ArrayList<? extends GrantedAuthority> getAuthorities(String username) {
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
