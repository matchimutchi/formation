package com.edugroupe.springlivrerestexercice.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edugroupe.springlivrerestexercice.metier.Role;
import com.edugroupe.springlivrerestexercice.metier.User;
import com.edugroupe.springlivrerestexercice.repositories.RoleRepository;
import com.edugroupe.springlivrerestexercice.repositories.UserRepository;




@Service
public class DatabaseContentInitiliser implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(userRepository.count() == 0) {
			System.out.println("La base est vide, création des utilisateurs et et roles par defaut");
			Role r_admin = roleRepository.save(new Role(0,"ROLE_ADMIN"));
			Role r_user = roleRepository.save(new Role(0,"ROLE_USER"));
			
			User jennifer = new User(0,"jennifer", passwordEncoder.encode("123456"), true);
			jennifer.setRoles(new HashSet<>());
			jennifer.getRoles().add(r_admin);
			jennifer.getRoles().add(r_user);
			userRepository.save(jennifer);
			
			User vincent = new User(0, "vincent", passwordEncoder.encode("123456"), true);
			vincent.setRoles(new HashSet<>());
			vincent.getRoles().add(r_user);
			userRepository.save(vincent);
		}
		else {
			System.out.println("La base contient déjà des utilisateurs");
		}
		
	}

}
