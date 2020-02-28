package com.edugroup.springboutique.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.springboutique.metier.Produit;

public interface ProduitRepository extends PagingAndSortingRepository<Produit, Integer> {

}
