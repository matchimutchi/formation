package com.edugroupe.springlivrerestexercice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroupe.springlivrerestexercice.metier.Auteur;

@RepositoryRestResource
public interface AuteurRepository extends PagingAndSortingRepository<Auteur, Integer> {

}
