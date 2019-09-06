package com.edugroupe.springproduituploadrep.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edugroupe.springproduituploadrep.metier.Role;
import com.edugroupe.springproduituploadrep.metier.User;
import com.edugroupe.springproduituploadrep.repositories.RoleRepository;
import com.edugroupe.springproduituploadrep.repositories.UserRepository;

/*
 * cette classe ecoute le contextRefreshEvent
 * dans notre cas, cela sera déclenché apres initilisation de tous les beans spring
 * mais avant que le travail de l'application ne démarre réellement
 * 
 * 
 * 
 * donc: 
 * 
 * 		-tous les beans spring sont disponible et pret à l'emploi
 * 			y compris les repositories
 * 		-mais aucun traitement de l'application normal (requette htpp, controller)
 * 			n ont envoie été exécuté
 * 
 * sprin reconnaitra le fait qu'on implement l'interface ApplicationListener
 * par contre il faut bien déclarer notre classe comme service ou component
 * si on veut qu'elle soit initialisée dans notre application
 */
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
			//il n'existe pas d'utilisateur dans la base
			//a nous de jouer
			System.out.println("La base est vide, création des utilisateurs et et roles par defaut");
			Role r_admin = roleRepository.save(new Role(0,"ROLE_ADMIN"));
			Role r_user = roleRepository.save(new Role(0,"ROLE_USER"));
			
			User admin = new User(0,"admin", passwordEncoder.encode("admin"), true);
			admin.setRoles(new HashSet<>());
			admin.getRoles().add(r_admin);
			admin.getRoles().add(r_user);
			userRepository.save(admin);
			
			User jennifer = new User(0, "jennifer", passwordEncoder.encode("123456"), true);
			jennifer.setRoles(new HashSet<>());
			jennifer.getRoles().add(r_user);
			userRepository.save(jennifer);
		}
		else {
			System.out.println("La base contient déjà des utilisateurs");
		}
		
	}

}
