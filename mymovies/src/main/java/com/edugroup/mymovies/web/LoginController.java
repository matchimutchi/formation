package com.edugroup.mymovies.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.mymovies.metier.Utilisateur;
import com.edugroup.mymovies.repositories.UtilisateurRepository;

@RestController
@RequestMapping("/mylogin")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@GetMapping
	public ResponseEntity<Utilisateur> LogMeIn(Principal principal) {
		return this.utilisateurRepository.findByLogin(principal.getName())
					.map(u -> new ResponseEntity<>(u, HttpStatus.ACCEPTED))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@PostMapping("/user/{username}")
	@PreAuthorize("#username == authentication.principal.username or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Utilisateur> userInfos(@PathVariable("username") String username){
		return utilisateurRepository.findWithRoleByLogin(username)
				.map(u -> new ResponseEntity<>(u, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}


}
