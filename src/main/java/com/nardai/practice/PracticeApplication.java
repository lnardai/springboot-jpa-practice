package com.nardai.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
@EnableOAuth2Sso
public class PracticeApplication {

	protected void configure(HttpSecurity http) throws Exception {
		http
				.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
}
