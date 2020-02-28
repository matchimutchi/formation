package com.edugroup.nanomania.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.nanomania.metier.Editeur;

@RepositoryRestResource
public interface EditeurRepository extends PagingAndSortingRepository<Editeur, Integer> {

}
