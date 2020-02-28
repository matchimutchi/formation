package com.edugroup.exercicesecurity.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.edugroup.exercicesecurity.metier.Livre;

public interface LivreRepository extends PagingAndSortingRepository<Livre, Integer> {
	
	
}
