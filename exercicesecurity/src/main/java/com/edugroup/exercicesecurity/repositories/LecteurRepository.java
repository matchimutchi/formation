package com.edugroup.exercicesecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.edugroup.exercicesecurity.metier.Lecteur;

public interface LecteurRepository extends PagingAndSortingRepository<Lecteur, Integer> {

	Optional<Lecteur> findByUsername(String username);
	
	@Query("select l from Lecteur l left join fetch l.roles where l.username=:username")
	Optional<Lecteur> findWithRoleByLogin(@Param("username") String username);
}
