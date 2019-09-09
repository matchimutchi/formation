package com.edugroupe.springlivrerestexercice.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edugroupe.springlivrerestexercice.metier.Auteur;
import com.edugroupe.springlivrerestexercice.metier.Livre;
import com.edugroupe.springlivrerestexercice.repositories.AuteurRepository;
import com.edugroupe.springlivrerestexercice.repositories.LivreRepository;





@Controller
@RequestMapping("/livres")
public class LivreController {

	@Autowired
	private LivreRepository livreRepository;
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	
	
	//-----------------------AFFICHER TT LES ELEMENTS-------------------------
	@GetMapping(value="/nopagelivres",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Iterable<Livre> liste(){
		return livreRepository.findAll();
	}
	
	
	
	@GetMapping(value="",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Page<Livre> pliste(@RequestParam("searchTerm") Optional<String> searchTerm,@PageableDefault(page = 0,size = 3) Pageable page){
		if(searchTerm.isPresent()) {
			return livreRepository.findByTitreContaining(searchTerm.get(), page);
		}else {
			return livreRepository.findAll(page);
		}
		
	
	}

	
	
	//-----------------------UN SEUL ELEMENT PAR L ID-------------------------
	@GetMapping(value = "/{id:[0-9]+}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<Livre> findById(@PathVariable("id") int id) {
		
		return livreRepository.findById(id).map(f -> new ResponseEntity<>(f, HttpStatus.OK))
									.orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		
	}
	
	
	//-----------------------INSERER UN ELEMENT PAR L ID-------------------------
	@PostMapping(value="",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Livre> insertLivre(@RequestBody Livre livre,@RequestParam("auteurId") int auteurId){
		Auteur a = auteurRepository.findById(auteurId).orElse(null);
		if( a == null) {
			return new ResponseEntity<Livre>(HttpStatus.NOT_ACCEPTABLE);
		}
		if(livre.getId() != 0) {
			return new ResponseEntity<Livre>(HttpStatus.BAD_REQUEST);
		}

		livre = livreRepository.save(livre);
		return new ResponseEntity<Livre>(livre, HttpStatus.CREATED);
	}
	
	
	
	//-----------------------MODIFIER UN ELEMENT PAR L ID-------------------------
	@PutMapping(value="",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Livre> updateLivre(@RequestBody Livre livre,@RequestParam("auteurId") int auteurId){
		
		Auteur a = auteurRepository.findById(auteurId).orElse(null);
		if( a == null) {
			return new ResponseEntity<Livre>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		Optional<Livre> l = livreRepository.findById(livre.getId());		
		if (!l.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Livre l2 = l.get();
		l2.setDateSortie(livre.getDateSortie());
		l2.setIsbn(livre.getIsbn());
		l2.setTitre(livre.getTitre());
		l2.setNbPages(livre.getNbPages());
		l2.setAuteur(auteurRepository.findById(auteurId).get());
		
		
		l2 = livreRepository.save(l2);
		return new ResponseEntity<Livre>(l2, HttpStatus.OK);
	}
	
	
	
	
	
	//-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
	@DeleteMapping(value="/{id:[0-9]+}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PreAuthorize(value="hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Map<String, Object>> deleteLivre(@PathVariable("id") int id){
		Optional<Livre> l = livreRepository.findById(id);
		if(!l.isPresent()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
		}else {
			livreRepository.delete(l.get());
			return new ResponseEntity<Map<String,Object>>(Collections.singletonMap("Ligne effacée", 1), HttpStatus.ACCEPTED);
		}
	}
	
	
	//-----------------------RECHERCHER DES  ELEMENTS PAR LA DUREE-------------------------
//	@GetMapping(value="/livres/titre/{titreAsc}", 
//				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	@CrossOrigin(origins = {"http://localhost:4200"})
//	public List<Livre> listeTitreAsc(@PathVariable("searchTerm") String searchTerm){
//		return livreRepository.findByTitreContaining(searchTerm);
//	}
//	
	
	
}
