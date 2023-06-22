package com.spring.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.spring.interceptor.AdminInterceptor;
import com.spring.interceptor.GuestInterceptor;
import com.spring.interceptor.UserInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GuestInterceptor())
		.addPathPatterns("/*")
		.excludePathPatterns("/index","/login" ,"/product" ,"/register" ,"/forget" ,"/detail" ,"/info");
		registry.addInterceptor(new UserInterceptor())
		.addPathPatterns("/admin/**" ,"/category/**" ,"/kichthuoc/**", "/manage-order/**","/account/**" ,"/login" ,"/register" ,"/forget", "/manage");
		registry.addInterceptor(new AdminInterceptor())
		.addPathPatterns("/login" ,"/register" ,"/forget");
		
	}

}
