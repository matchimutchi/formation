package com.edugroupe.springmoviesrest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.edugroupe.springmoviesrest.metier.Film;

@RepositoryRestResource
public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {

	List<Film> findByDureeGreaterThan(int duree);
}

