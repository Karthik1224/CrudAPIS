//package com.example.demo.utility;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class UniqueIdFilterConfiguration {
//	@Bean
//	public FilterRegistrationBean<SimpleFilter> servletRegistrationBean() {
//		FilterRegistrationBean<SimpleFilter> registrationBean = new FilterRegistrationBean<>();
//		SimpleFilter log4jMDCFilterFilter = new SimpleFilter();
//		registrationBean.setFilter(log4jMDCFilterFilter);
//		registrationBean.setOrder(2);
//		return registrationBean;
//	}
//
//}
