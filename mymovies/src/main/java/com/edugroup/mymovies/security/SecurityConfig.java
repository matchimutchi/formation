package com.edugroup.mymovies.security;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private PasswordEncoder passwordEncoder;
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		if(passwordEncoder == null) {
			passwordEncoder = new BCryptPasswordEncoder();
		}
		return passwordEncoder;
		
	}
	
	

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
//		.configurationSource(new CorsConfigurationSource() {	
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				CorsConfiguration cf = new CorsConfiguration();
//				cf.applyPermitDefaultValues();
//				cf.addAllowedOrigin("http://localhost:4200");
//				cf.addAllowedMethod(HttpMethod.GET);
//				cf.addAllowedMethod(HttpMethod.POST);
//				cf.addAllowedMethod(HttpMethod.PUT);
//				cf.addAllowedMethod(HttpMethod.DELETE);
//				cf.addAllowedMethod(HttpMethod.OPTIONS);
//				return cf;
//			}
//		})
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests().antMatchers("/api","/api/**").hasRole("ADMIN")
								.antMatchers("/movies" , "/movies/**").authenticated()
								.antMatchers("/mylogin").authenticated()
								.and().httpBasic()
								.and().csrf().disable();
	}
	
	
	




	
	
	
	
	
	

}
