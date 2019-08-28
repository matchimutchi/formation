package com.edugroupe.springlivrerestexercice.web;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edugroupe.springlivrerestexercice.metier.Auteur;
import com.edugroupe.springlivrerestexercice.repositories.AuteurRepository;


@Controller
public class AuteurController {

	@Autowired
	private AuteurRepository auteurRepository;
	
	
	
	//-----------------------AFFICHER TT LES ELEMENTS-------------------------
	@GetMapping(value="/nopageauteurs",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Iterable<Auteur> liste(){
		return auteurRepository.findAll();
	}
	
	
	
	@GetMapping(value="/auteurs",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Page<Auteur> pliste(@PageableDefault(page = 0,size = 10) Pageable page){
		return auteurRepository.findAll(page);
	}

	
	
	//-----------------------UN SEUL ELEMENT PAR L ID-------------------------
	@GetMapping(value = "/auteurs/{id:[0-9]+}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Auteur> findById(@PathVariable("id") int id) {
		
		return auteurRepository.findById(id).map(a -> new ResponseEntity<>(a, HttpStatus.OK))
									.orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	//-----------------------INSERER UN ELEMENT PAR L ID-------------------------
	@PostMapping(value="/auteurs",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Auteur> insertAuteur(@RequestBody Auteur auteur){
		if(auteur.getId() != 0) {
			return new ResponseEntity<Auteur>(HttpStatus.BAD_REQUEST);
		}

		auteur = auteurRepository.save(auteur);
		return new ResponseEntity<Auteur>(auteur, HttpStatus.CREATED);
	}
	
	
	
	//-----------------------MODIFIER UN ELEMENT PAR L ID-------------------------
	@PutMapping(value="/auteurs",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Auteur> updateLivre(@RequestBody Auteur auteur){
		Optional<Auteur> a = auteurRepository.findById(auteur.getId());
		if (!a.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Auteur a2 = a.get();
		a2.setNom(auteur.getNom());
		a2.setPrenom(auteur.getPrenom());
		
		
		a2 = auteurRepository.save(a2);
		return new ResponseEntity<Auteur>(a2, HttpStatus.OK);
	}
	
	
	
	
	
	//-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
	@DeleteMapping(value="/auteurs/{id:[0-9]+}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Map<String, Object>> deleteLivre(@PathVariable("id") int id){
		Optional<Auteur> a = auteurRepository.findById(id);
		if(!a.isPresent()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
		}else {
			auteurRepository.delete(a.get());
			return new ResponseEntity<Map<String,Object>>(Collections.singletonMap("Ligne effacée", 1), HttpStatus.ACCEPTED);
		}
	}
	
}
