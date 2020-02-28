package com.edugroup.livreinfos.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.livreinfos.metier.Livre;


public interface LivreRepository extends PagingAndSortingRepository<Livre, Integer> {

	Optional<Livre> findByIsbn(String isbn);
}
