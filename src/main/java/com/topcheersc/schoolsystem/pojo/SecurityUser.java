package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月27日上午10:58:28
* @Description:
*/
public class SecurityUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role_name;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public SecurityUser(String username, String password, String role_name) {
		super();
		this.username = username;
		this.password = password;
		this.role_name = role_name;
	}
	public SecurityUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SecurityUser [username=" + username + ", password=" + password + ", role_name=" + role_name + "]";
	}
	
}
