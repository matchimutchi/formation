package com.edugroup.securityandoauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthorizationRequestRepository customAuthorizationRequestRepository() {
		return new HttpSessionOAuth2AuthorizationRequestRepository();
	}
	
	@Autowired
	private OidcUserService oidcUserService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
					.and().oauth2Login()
					//customisation de l'url pour l'authoriazation Oauth
					.authorizationEndpoint().baseUri("/oauth2/authorize")
					.authorizationRequestRepository(customAuthorizationRequestRepository())
					//url a laquelle google nous rappellera 
					//transmis avec notre requete 
					.and().redirectionEndpoint().baseUri("/oauth2/callback/*")
					//personnalisé l'extraction d'information
					.and().userInfoEndpoint().oidcUserService(oidcUserService);
	}
	
	
	
	
		
	
}
