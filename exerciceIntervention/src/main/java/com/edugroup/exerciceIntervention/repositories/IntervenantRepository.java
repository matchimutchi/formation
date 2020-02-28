package com.edugroup.exerciceIntervention.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.exerciceIntervention.metier.Intervenant;

public interface IntervenantRepository extends PagingAndSortingRepository<Intervenant, Integer> {

}
