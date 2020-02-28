package com.edugroup.revision2.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.revision2.metier.Terroir;

@RepositoryRestResource
public interface TerroirRepositories extends PagingAndSortingRepository<Terroir, Integer> {

}
