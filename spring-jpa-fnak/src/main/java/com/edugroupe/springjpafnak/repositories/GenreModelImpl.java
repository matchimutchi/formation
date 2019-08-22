package com.edugroupe.springjpafnak.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.edugroupe.springjpafnak.metier.Genre;

@Service
public class GenreModelImpl implements GenreModel {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Genre> findAll(){
		return em.createQuery("From Genre",Genre.class).getResultList();
	}
	
	
	

}
