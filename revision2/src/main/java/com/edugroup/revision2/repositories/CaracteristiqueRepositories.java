package com.edugroup.revision2.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.revision2.metier.Caracteristique;

@RepositoryRestResource(exported = true)
public interface CaracteristiqueRepositories extends PagingAndSortingRepository<Caracteristique, Integer> {

}
