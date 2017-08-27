package com.nardai.practice;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class SpringTestConfiguration {

	//needed for mocking SpringOauth2 configuration
	@Bean
	public ResourceServerTokenServices remoteTokenServices() {
		return null;
	}

	@Bean
	public ResourceServerProperties getResourceServerProperties() {
		return null;
	}


}
