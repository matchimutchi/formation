package com.edugroup.mymovies.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.edugroup.mymovies.metier.Movie;

@RepositoryRestResource
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

	
}
