package com.edugroupe.springlivrerestexercice.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroupe.springlivrerestexercice.metier.Livre;

@RepositoryRestResource
public interface LivreRepository extends PagingAndSortingRepository<Livre, Integer> {

	Page<Livre> findByTitreContaining(String searchTerm, Pageable page);
}
