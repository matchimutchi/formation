package com.edugroup.junitandspring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.junitandspring.metier.Produit;
import com.edugroup.junitandspring.repositories.ProduitRepository;

@RestController
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping
	public Produit home() {
		return produitRepository.getProduit();
	}
}
