package com.nardai.practice;

import static springfox.documentation.builders.PathSelectors.any;

import io.swagger.models.auth.OAuth2Definition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String securitySchemaOAuth2 = "oauth2schema";
	public static final String authorizationScopeGlobal = "public_profile";
	public static final String authorizationScopeGlobalDesc ="accessEverything";

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nardai.practice"))
				.paths(any())
				.build()
				.securitySchemes(securitySchema())
				.securityContexts(securityContext());
	}

	@Bean
	public SecurityConfiguration security() {
		return new SecurityConfiguration(
				"1857573394496421", "d335b4de2cfe256679d86cee4e7865da", "realm", "Spring Oauth Test", null, ApiKeyVehicle.HEADER, "api_key", ",");
	}

	private List<OAuth> securitySchema() {
		AuthorizationScope authorizationScope = new AuthorizationScope(authorizationScopeGlobal, authorizationScopeGlobal);
		TokenRequestEndpoint  tokenRequestEndpoint = new TokenRequestEndpoint ("https://www.facebook.com/dialog/oauth", "client_id" ,"client_secret");
		TokenEndpoint tokenEndpoint = new TokenEndpoint("https://www.facebook.com/dialog/oauth", "access_token");
		AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint);
		List s = new ArrayList();
		s.add(authorizationScope);
		List d = new ArrayList();
		d.add(authorizationCodeGrant);
		List<OAuth> list = new ArrayList<>();
		list.add(new OAuth(securitySchemaOAuth2, s, d));
		return list;
	}

	private List<SecurityContext> securityContext() {
		List<SecurityContext> list = new ArrayList<>();
		list.add(SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.any())
				.build());
		return list;
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope(authorizationScopeGlobal, authorizationScopeGlobalDesc);
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List d = new ArrayList();
		d.add(new SecurityReference(securitySchemaOAuth2, authorizationScopes));
		return new ArrayList(d);
	}

}