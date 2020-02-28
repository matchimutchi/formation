package com.edugroup.nanomania.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.edugroup.nanomania.metier.JeuVideo;

@RepositoryRestResource
public interface JeuxVideoRepository extends PagingAndSortingRepository<JeuVideo, Integer> {
	
	@RestResource(path = "byEditeur", rel = "customFindMethod")
	 Page<JeuVideo> findByEditeurId(int editeurId, Pageable page);
}
