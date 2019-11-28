package com.topcheersc.schoolsystem.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
* @author YX
* @date 2019年11月27日下午7:44:46
* @Description:
*/
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {
    
	/*public SecurityWebApplicationInitializer() {
	    super(WebSecurityConfig.class);
	}*/
    
}
