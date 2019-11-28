package com.topcheersc.schoolsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.topcheersc.schoolsystem.security.LoginFailureHandler;
import com.topcheersc.schoolsystem.security.LoginSuccessHandler;
import com.topcheersc.schoolsystem.security.MyAccessDeniedHandler;
import com.topcheersc.schoolsystem.security.UnauthorizedEntryPoint;
import com.topcheersc.schoolsystem.service.impl.CustomUserDetailsService;

/**
* @author YX
* @date 2019年11月27日下午7:24:29
* @Description:
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	static {
		System.out.println("开始配置！！！");
	}
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	@Autowired
	LoginFailureHandler loginFailureHandler;
	
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置不拦截规则
        web.ignoring().antMatchers("/assets/**",
                "/index.html",
                "/login.html",
                "/404.jsp",
                "/error.jsp");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * authorizeRequests()  配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
         * formLogin()          对应表单认证相关的配置
         * logout()             对应了注销相关的配置
         * httpBasic()          可以配置basic登录
         * etc
         * sessionManagement()  session管理
         */
    	
        http
        		.headers().frameOptions().disable()
        		.and()
                .authorizeRequests()
	                .antMatchers("/page/user/*").hasRole("USER")
	                .antMatchers("/page/teacher/*").hasRole("TEACHER")
	                .antMatchers("/user/addUser").hasRole("ADMIN")
	                .antMatchers("/user/editUser").hasRole("ADMIN")
                    /*
                    anyRequest：任何的请求
                    authenticated：认证
                    */
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                	.successForwardUrl("/index.html")
                    .failureForwardUrl("/login.html?error=true")
                    .loginPage("/login.html")
                    .successHandler(loginSuccessHandler)/* 设置登录成功处理器 */
                    .failureHandler(loginFailureHandler)/* 设置登陆失败处理器 */
                    .loginProcessingUrl("/login")
                    .permitAll()
                    .and()
                /*
                // 定义登录认证失败后执行的操作
                .failureHandler(this.authenticationFailureHandler())
                // 定义登录认证曾工后执行的操作
                .successHandler(this.authenticationSuccessHandler());
                */
                .exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login.html?error=logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                .httpBasic()
                    .disable()
                // 禁用 CSRF
                .csrf()
                    .disable()
                // session管理
                .sessionManagement()
                    .sessionFixation().none().maximumSessions(1);
        		
    }
 
    /**
     * 登录认证配置
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
 
    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
 
}