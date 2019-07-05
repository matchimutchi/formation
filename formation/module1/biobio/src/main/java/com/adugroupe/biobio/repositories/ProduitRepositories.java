package com.adugroupe.biobio.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.adugroupe.biobio.metier.Produit;

@CrossOrigin
// modifier le T avec notre nom de class Produit et signifier que la clée primaire est un entier
public interface ProduitRepositories extends PagingAndSortingRepository<Produit, Integer> {
	
	List<Produit> findByPrixLessThan(double prixmax);
	List<Produit> findByNomContaining(String searchTerm);
}
