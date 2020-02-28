package com.edugroup.exercicesecurity.util;


import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edugroup.exercicesecurity.metier.Lecteur;

import com.edugroup.exercicesecurity.metier.Role;
import com.edugroup.exercicesecurity.repositories.LecteurRepository;

import com.edugroup.exercicesecurity.repositories.RoleRepository;

@Service
public class DatabaseInitilialiser implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private LecteurRepository lecteurRepository;

	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(lecteurRepository.count() == 0 && roleRepository.count() == 0 ) {
			Role r1 = new Role(0,"ROLE_ADMIN",null);
			Role r2 = new Role(0,"ROLE_USER",null);
			r1 = roleRepository.save(r1);
			r2 = roleRepository.save(r2);
			
			Lecteur u1 = new Lecteur(0,"admin",passwordencoder.encode("admin"),true,new HashSet<>(),new HashSet<>());
			u1.getRoles().add(r1);
			u1.getRoles().add(r2);
			lecteurRepository.save(u1);
			
			Lecteur u2 = new Lecteur(0,"jenny",passwordencoder.encode("1234"),true,new HashSet<>(),new HashSet<>());
			u2.getRoles().add(r2);
			lecteurRepository.save(u2);
		}
		
	}

}
