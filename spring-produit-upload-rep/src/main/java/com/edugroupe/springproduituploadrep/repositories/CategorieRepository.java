package com.edugroupe.springproduituploadrep.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.Categorie;
import com.edugroupe.springproduituploadrep.metier.Produit;


public interface CategorieRepository extends PagingAndSortingRepository<Categorie, Integer>,CategorieRepositoryCustom{



}
