package com.edugroupe.springmoviesrest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springmoviesrest.metier.Acteur;

public interface ActeurRepository extends PagingAndSortingRepository<Acteur, Integer> {

	
}
