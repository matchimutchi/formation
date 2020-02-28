package com.edugroup.exercicesecurity.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edugroup.exercicesecurity.metier.Lecteur;
import com.edugroup.exercicesecurity.repositories.LecteurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private LecteurRepository lecteurRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Lecteur> l = lecteurRepository.findWithRoleByLogin(username);
		if(!l.isPresent()) {
			throw new UsernameNotFoundException("username/password invalide");
		}
		return new CustomUserDetails(l.get());
	}
	
	
	
}
