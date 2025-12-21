package com.spring.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	//bean definition - is a method to create a spring bean
	// the method name is the bean name
	@Bean
	Backend getBackend() {
		return new Backend();
	}
	
	@Bean
	@Primary
	Frontend frontend() {
		return new Frontend();
	}
	
	@Bean
	Institute institute() {
		return new Institute();
	}
	
}






