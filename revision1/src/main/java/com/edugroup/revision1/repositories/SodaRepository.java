package com.edugroup.revision1.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.revision1.metier.Soda;

@RepositoryRestResource
public interface SodaRepository extends PagingAndSortingRepository<Soda, Integer> {

	
}
