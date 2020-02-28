package com.edugroup.trajetinfos.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.trajetinfos.metier.Trajet;

public interface TrajetRepository extends PagingAndSortingRepository<Trajet, Integer> {

	List<Trajet> findBytrajetId(String trajetId);
}
