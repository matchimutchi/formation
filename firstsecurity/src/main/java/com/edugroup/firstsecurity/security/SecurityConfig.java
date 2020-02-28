package com.edugroup.firstsecurity.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//jsr250Enabled -> @RoleAllowed possible
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private PasswordEncoder passwordEncoder;
	

	
	
	//cet encoder n'encode rien
	//spring security depuis spring 5, requiert obligatoirement
	//un password encoder
	//celui ci est censé encoder les mots de passes ( typiquement par hashage)
	//ici, on ne veut pas hasher les mot de passe donc on utiliser un encoder spéciale qui ne fait rien
	//le NoOpPasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		if(passwordEncoder == null) {
			passwordEncoder = new BCryptPasswordEncoder();
			//passwordEncoder = NoOpPasswordEncoder.getInstance();
		}
		return passwordEncoder;
		
	}
	
	
	//recuperation utilisateur par login
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//authentification en mémoire les comptes utilisateurs sont définis directement ici
		// et n'existe que dans la mémoire après
		//utile dans des cas simple ou pour tester
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER").and()
//									.withUser("jenny").password("123456").roles("USER").and()
//									.passwordEncoder(passwordEncoder());
		
		//authentification via un service custon, ici le notre 
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home/admin").hasRole("ADMIN")
								.antMatchers("/home").hasAnyRole("ADMIN","USER")
								.antMatchers("/infos/**").authenticated()
								.antMatchers("/").authenticated().and().httpBasic();
	}
	
	
	




	
	
	
	
	
	

}
