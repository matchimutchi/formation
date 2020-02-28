package com.edugroup.exercicesecurity.web;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.exercicesecurity.metier.Lecteur;
import com.edugroup.exercicesecurity.metier.Livre;
import com.edugroup.exercicesecurity.repositories.LecteurRepository;
import com.edugroup.exercicesecurity.repositories.LivreRepository;


@RestController
@RequestMapping("/livres")
public class LivresController {
	
	
	
	@Autowired
	private LecteurRepository lecteurRepository;
	
	
	@Autowired
	private LivreRepository livreRepository;
	
	@GetMapping("/livres")
	@RolesAllowed({"ROLE_ADMIN,ROLE_USER"})
	public Iterable<Livre> listeLivres(){
		return livreRepository.findAll();
	}
	
	@GetMapping("/user/{username}")
	@PreAuthorize("#username == authentication.principal.username or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Lecteur> userInfos(@PathVariable("username") String username){
		return lecteurRepository.findWithRoleByLogin(username)
				.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/user/{username}/add/{id}")
	@PreAuthorize("#username == authentication.principal.username ")
	public ResponseEntity<Livre> userAjout(@PathVariable("username") String username,@PathVariable("id") int id){
		Lecteur l = lecteurRepository.findByUsername(username).get();
		Optional<Livre> li = livreRepository.findById(id);
		if(li.isPresent()) {
			l.getLivres().add(li.get());
			lecteurRepository.save(l);
			return new ResponseEntity<Livre>(li.get(),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Livre>(HttpStatus.BAD_REQUEST);
		
	}

}
