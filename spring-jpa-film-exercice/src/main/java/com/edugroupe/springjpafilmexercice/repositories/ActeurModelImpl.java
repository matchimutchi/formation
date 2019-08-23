package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;


@Service
public class ActeurModelImpl implements ActeurModel {
	
	
	@PersistenceContext
	public EntityManager em;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Acteur> findAll(){

		return em.createQuery("FROM Acteur",Acteur.class).getResultList();

	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Acteur findById(int id) {
		return em.find(Acteur.class, id);
	}
	

	@Transactional
	public Acteur save(Acteur acteur){
	
		if(acteur.getId() == 0) {
			em.persist(acteur);
		}else {
			acteur = em.merge(acteur);
		}
		return acteur;
	
	}
	

	@Transactional
	public boolean deleteById(int id) {
		Acteur a = em.find(Acteur.class, id);
		if(a == null)
			return false;
		em.remove(a);
		return true;
				
	}
}
