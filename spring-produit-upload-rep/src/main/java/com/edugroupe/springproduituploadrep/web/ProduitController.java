package com.edugroupe.springproduituploadrep.web;


import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.edugroupe.springproduituploadrep.metier.Produit;
import com.edugroupe.springproduituploadrep.repositories.CategorieRepository;
import com.edugroupe.springproduituploadrep.repositories.ImageRepository;
import com.edugroupe.springproduituploadrep.repositories.ProduitRepository;




@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	//----------------------------------RECHERCHER TTES LES IMAGES-----------------------
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public Page<Produit> findAll(@PageableDefault(page = 0,size = 10) Pageable page){
		return produitRepository.findAll(page);		
	}
	
	
	//----------------------------------RECHERCHER UNE IMAGE-----------------------
	@GetMapping(value="/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Produit> findById(@PathVariable("id") int id) {
		return produitRepository.findById(id)
								.map(p -> new ResponseEntity<>(p , HttpStatus.OK))
								.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	


	
	//-----------------------INSERER UN ELEMENT PAR L ID-------------------------
	@PostMapping(value="",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			//consume signifie qu'on recoit du json
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Produit> insertProduit(@RequestBody Produit produit){
		if(produit.getId() != 0) {
			return new ResponseEntity<Produit>(HttpStatus.BAD_REQUEST);
		}
		//requestBody le corp de la requete va contenir en json ici notre objet
		produit = produitRepository.save(produit);
		return new ResponseEntity<Produit>(produit, HttpStatus.CREATED);
	}
	
	
	
	
	//-----------------------MODIFIER UN ELEMENT PAR L ID-------------------------
	@PutMapping(value="",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			//consume signifie qu'on recoit du json
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Produit> updateProduit(@RequestBody Produit produit){
		Optional<Produit> p = produitRepository.findById(produit.getId());
		if (!p.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Produit p2 = p.get();
		//f2.setId(film.getId());
		p2.setNom(produit.getNom());
		p2.setPrix(produit.getPrix());
		p2.setPoids(produit.getPoids());
		
		p2 = produitRepository.save(p2);
		return new ResponseEntity<Produit>(p2, HttpStatus.OK);
	}
	
	
	
	
	//-----------------------SUPPRIMER UN ELEMENT PAR L ID-------------------------
	@DeleteMapping(value="/{id:[0-9]+}",
			//produce signifie qu'on envoie du json
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin(origins = {"http://localhost:4200"})
	public ResponseEntity<Map<String, Object>> deleteFilm(@PathVariable("id") int id){
		Optional<Produit> p = produitRepository.findById(id);
		if(!p.isPresent()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
		}else {
			produitRepository.delete(p.get());
			return new ResponseEntity<Map<String,Object>>(Collections.singletonMap("Ligne effacée", 1), HttpStatus.ACCEPTED);
		}
	}
	
	
	
	

	
}
