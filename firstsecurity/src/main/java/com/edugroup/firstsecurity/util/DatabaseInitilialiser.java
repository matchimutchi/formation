package com.edugroup.firstsecurity.util;

import java.util.Collections;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edugroup.firstsecurity.metier.Role;
import com.edugroup.firstsecurity.metier.Utilisateur;
import com.edugroup.firstsecurity.repositories.RoleRepository;
import com.edugroup.firstsecurity.repositories.UtilisateurRepository;

@Service
public class DatabaseInitilialiser implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(utilisateurRepository.count() == 0 && roleRepository.count() == 0 ) {
			Role r1 = new Role(0,"ROLE_ADMIN",null);
			Role r2 = new Role(0,"ROLE_USER",null);
			Role r3 = new Role(0,"ROLE_VISITEUR",null);
			r1 = roleRepository.save(r1);
			r2 = roleRepository.save(r2);
			r3 = roleRepository.save(r3);
			
			Utilisateur u1 = new Utilisateur(0,"admin",passwordencoder.encode("admin"),true,new HashSet<>());
			u1.getRoles().add(r1);
			u1.getRoles().add(r2);
			utilisateurRepository.save(u1);
			
			Utilisateur u2 = new Utilisateur(0,"jenny",passwordencoder.encode("1234"),true,new HashSet<>());
			u2.getRoles().add(r2);
			u2.getRoles().add(r3);
			utilisateurRepository.save(u2);
		}
		
	}

}
