package com.edugroup.exerciceIntervention.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.exerciceIntervention.metier.Intervention;

public interface InterventionRepository extends PagingAndSortingRepository<Intervention, Integer> {

}
