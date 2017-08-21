package com.nardai.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableOAuth2Sso
@EnableWebSecurity
public class PracticeApplication {

	protected void configure(HttpSecurity http) throws Exception {
		http
				.antMatcher("/v1")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**", "/swagger**")
				.permitAll()
				.anyRequest()
				.authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
}
