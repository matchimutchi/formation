package com.edugroupe.springjpafnak.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.edugroupe.springjpafnak.metier.Auteur;

@Service
public class AuteurModelImpl implements AuteurModel {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Auteur> findAll(){
		return em.createQuery("From Auteur",Auteur.class).getResultList();
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public boolean deleteById(int id){
//		Auteur a = em.find(Auteur.class,id);
//		if(a == null)
//			return false;
//		em.remove(a);
//		return true;
//		
//	}
	

}
