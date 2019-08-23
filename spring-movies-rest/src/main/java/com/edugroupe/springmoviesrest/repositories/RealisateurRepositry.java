package com.edugroupe.springmoviesrest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroupe.springmoviesrest.metier.Realisateur;


@RepositoryRestResource
public interface RealisateurRepositry extends PagingAndSortingRepository<Realisateur, Integer> {
	
}
