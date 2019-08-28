package com.edugroupe.springmoviesrest.web;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.edugroupe.springmoviesrest.metier.Film;
import com.edugroupe.springmoviesrest.repositories.FilmRepository;

@Controller
public class FilmController {

	@Autowired
	private FilmRepository filmRepository;
	
	
	
	//-----------------------AFFICHER TT LES ELEMENTS-------------------------
	@GetMapping(value="/nopagefilms",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Iterable<Film> liste(){
		return filmRepository.findAll();
	}
	
	
	
	//-----------------------PAGINATION-------------------------
	//pour la pagination un PageableDefault extraira les parametre
	// page =... -> no pgae
	//size=.. -> taille des pages
	
	//quand une page est renvoyée, elle contient, en plus des infos de pagination
	//un champ "content" qui est le tableau des données actuelles de la page
	//il executer réellement des requetes SQL paginées
	@GetMapping(value="/films",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Page<Film> pliste(@PageableDefault(page = 0,size = 3) Pageable page){
		//PageRequest pr = new PageRequest(page, size);
		return filmRepository.findAll(page);
	}
	
	
	
	
	//-----------------------UN SEUL ELEMENT PAR L ID-------------------------
	@GetMapping(value = "/films/{id:[0-9]+}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Film> findById(@PathVariable("id") int id) {
		
		//cela sert a definir une reponse si l id existe : OK sinon affiche une erreur 404
		return filmRepository.findById(id).map(f -> new ResponseEntity<>(f, HttpStatus.OK))
									.orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));

		
		//le type opptinal a été introduit entre autre pour les stream
		//comme son nom l'indique, le contenu peut être préésent ou non
		//cela evite d'avoir directement a gerer les null
		//pour verifier s'il est présent --> get
		/*Optional<Film> film =filmRepository.findById(id);
		if(film.isPresent()) {
			return film.get();
		}else {
			return null;
		}*/
		
	}
	
	
	
	//-----------------------INSERER UN ELEMENT PAR L ID-------------------------
	@PostMapping(value="/films",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			//consume signifie qu'on recoit du json
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Film> insertFilm(@RequestBody Film film){
		if(film.getId() != 0) {
			return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
		}
		//requestBody le corp de la requete va contenir en json ici notre objet
		film = filmRepository.save(film);
		return new ResponseEntity<Film>(film, HttpStatus.CREATED);
	}
	
	
	
	
	//-----------------------MODIFIER UN ELEMENT PAR L ID-------------------------
	@PutMapping(value="/films",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			//consume signifie qu'on recoit du json
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Film> updateFilm(@RequestBody Film film){
		Optional<Film> f = filmRepository.findById(film.getId());
		if (!f.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Film f2 = f.get();
		//f2.setId(film.getId());
		f2.setDateSortie(film.getDateSortie());
		f2.setDuree(film.getDuree());
		f2.setNom(film.getNom());
		
		f2 = filmRepository.save(f2);
		return new ResponseEntity<Film>(f2, HttpStatus.OK);
	}
	
	
	
	
	//-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
	@DeleteMapping(value="/films/{id:[0-9]+}",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Map<String, Object>> deleteFilm(@PathVariable("id") int id){
		Optional<Film> f = filmRepository.findById(id);
		if(!f.isPresent()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
		}else {
			filmRepository.delete(f.get());
			return new ResponseEntity<Map<String,Object>>(Collections.singletonMap("Ligne effacée", 1), HttpStatus.ACCEPTED);
		}
	}
	
	
	
	
	//-----------------------RECHERCHER DES  ELEMENTS PAR LA DUREE-------------------------
	@GetMapping(value="/films/duree/{dureeMin}", 
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Film> listeDureeMin(@PathVariable("dureeMin") int dureeMin){
		return filmRepository.findByDureeGreaterThan(dureeMin);
	}
	
	
	
}
