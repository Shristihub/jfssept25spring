package com.productapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebConfig{

	
//	authentication
	@Bean
	AuthenticationManager authenticate(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	//passwordencoder bean
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
//	bean for securityfilter chain - authorization
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) {
		return  http
		    .csrf((csrf)->csrf.disable())
			.authorizeHttpRequests(authorize->{
				authorize
				.requestMatchers("/register","/greet").permitAll()
				.requestMatchers("/product-api/v1/products/**").hasAnyAuthority("ADMIN","USER")
				.requestMatchers("/product-api/v1/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated();
			})
			.httpBasic(Customizer.withDefaults())
			.build();
	}
}


















