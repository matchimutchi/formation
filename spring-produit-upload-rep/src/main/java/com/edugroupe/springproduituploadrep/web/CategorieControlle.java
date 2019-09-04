package com.edugroupe.springproduituploadrep.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edugroupe.springproduituploadrep.metier.Categorie;
import com.edugroupe.springproduituploadrep.metier.Produit;
import com.edugroupe.springproduituploadrep.repositories.CategorieRepository;

@Controller
@RequestMapping("/categories")
public class CategorieControlle {

	
	@Autowired
	private CategorieRepository categorieRepository;
	
	
	
	
	//----------------------------------RECHERCHER TTES LES IMAGES-----------------------
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public Iterable<Categorie> findAll(@PageableDefault(page = 0,size = 10) Pageable page){
		return categorieRepository.findAll(page);		
	}
	
	
	//----------------------------------RECHERCHER UNE IMAGE-----------------------
	@GetMapping(value="/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<Categorie> findById(@PathVariable("id") int id) {
		return categorieRepository.findById(id)
								.map(p -> new ResponseEntity<>(p , HttpStatus.OK))
								.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
}
