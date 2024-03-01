package com.nisum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	private static final String REQUEST_MATCHER = "/**";
	private static final String REQUEST_H2_CONSOLE = "/h2-console/**";
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request -> request.requestMatchers(REQUEST_MATCHER).permitAll().requestMatchers(REQUEST_H2_CONSOLE).permitAll())
				.csrf((csrf) -> csrf.disable())
				.headers(header -> header.frameOptions(frame -> frame.disable()));
		return http.build();
	}
	
}
