package com.edugroup.nanomania.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.nanomania.metier.Plateforme;

@RepositoryRestResource
public interface PlateFormeRepository extends PagingAndSortingRepository<Plateforme, Integer> {

}
