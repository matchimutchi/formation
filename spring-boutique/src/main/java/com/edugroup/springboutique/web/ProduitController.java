package com.edugroup.springboutique.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.springboutique.metier.Produit;
import com.edugroup.springboutique.repositories.ProduitRepository;

@RestController
@RequestMapping("/produits")
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	//voir une page
	@GetMapping
	public Page<Produit> list(@PageableDefault(page =0,size = 10)Pageable page){
		return produitRepository.findAll(page);
	}
	
	
	//Sélectionner un élément uniquement
	//optional zero ou un objet dedans
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Produit> findById(@PathVariable("id") int id){
		return produitRepository.findById(id)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	@PostMapping
	public ResponseEntity<Produit> save(@RequestBody Produit p){
		if(p.getId() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Produit>(produitRepository.save(p),HttpStatus.CREATED);
	}
	
	

}
