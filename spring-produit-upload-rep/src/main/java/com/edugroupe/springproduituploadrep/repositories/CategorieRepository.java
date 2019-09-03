package com.edugroupe.springproduituploadrep.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.Categorie;


public interface CategorieRepository extends PagingAndSortingRepository<Categorie, Integer>,CategorieRepositoryCustom{

}
