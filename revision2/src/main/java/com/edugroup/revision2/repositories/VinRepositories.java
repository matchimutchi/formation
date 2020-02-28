package com.edugroup.revision2.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.revision2.metier.Vin;

@RepositoryRestResource
public interface VinRepositories extends PagingAndSortingRepository<Vin, Integer> {

}
