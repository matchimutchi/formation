package com.edugroupe.springproduituploadrep.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.Produit;

public interface ProduitRepository extends PagingAndSortingRepository<Produit, Integer>, ProduitRepositoryCustom {

}
