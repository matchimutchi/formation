package com.edugroupe.springvoiturerestxml.repositories;

import org.springframework.data.repository.CrudRepository;

import com.edugroupe.springvoiturerestxml.metier.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Integer> {

	
}
