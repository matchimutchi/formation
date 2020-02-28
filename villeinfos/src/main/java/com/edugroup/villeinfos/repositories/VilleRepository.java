package com.edugroup.villeinfos.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.edugroup.villeinfos.metier.Ville;

public interface VilleRepository extends PagingAndSortingRepository<Ville, Integer> {

	Optional<Ville> findByNom(String nom);
}
