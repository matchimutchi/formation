package com.edugroup.nanomania.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.edugroup.nanomania.metier.Genre;

@RepositoryRestResource
public interface GenreRepository extends PagingAndSortingRepository<Genre, Integer> {

}
