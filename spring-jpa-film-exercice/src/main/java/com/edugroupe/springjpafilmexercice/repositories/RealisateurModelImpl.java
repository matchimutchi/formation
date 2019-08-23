package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;
import com.edugroupe.springjpafilmexercice.metier.Film;
import com.edugroupe.springjpafilmexercice.metier.Realisateur;

@Service
public class RealisateurModelImpl implements RealisateurModel {

	

	@PersistenceContext
	public EntityManager em;
	

	@Override
	@Transactional(readOnly = true)
	public List<Realisateur> findAll(boolean withFilm){
		if(withFilm) {
			return em.createQuery("SELECT DISTINCT(r) FROM Realisateur as r LEFT JOIN fetch r.films",Realisateur.class).getResultList();
		}else{
			return em.createQuery("FROM Realisateur",Realisateur.class).getResultList();
		}
		

	}
	
	@Override
	@Transactional(readOnly = true)
	public Realisateur findById(int id) {
		return em.find(Realisateur.class, id);
	}
	

	@Override
	@Transactional
	public Realisateur save(Realisateur realisateur){

		if(realisateur.getId() == 0) {
			em.persist(realisateur);
			
		}else {
			Realisateur oldRealisateur = em.find(Realisateur.class,realisateur.getId());
			realisateur.setFilms(oldRealisateur.getFilms());
			realisateur = em.merge(realisateur);
		}
		return realisateur;
	
	}
	

	@Override
	@Transactional
	public boolean deleteById(int id) {
		Realisateur r = em.find(Realisateur.class, id);
		if(r == null)
			return false;
		em.remove(r);
		return true;
				
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Film> findRealisateurFilm(int realisateurId){
		TypedQuery<Film> q = em.createQuery("SELECT f FROM Film as f JOIN f.realisateurs as r WHERE r.id = :realisateurId",Film.class);
		q.setParameter("realisateurId", realisateurId);
		return q.getResultList();
	}
	
	
	@Override
	@Transactional
	public boolean addFilmToRealisateur(int realisateurId, int filmId) {
		Realisateur realisateur = em.find(Realisateur.class, realisateurId);
		Film film  = em.find(Film.class, filmId);
		if(realisateur == null || film == null) {
			return false;		
		}
		
		realisateur.getFilms().add(film);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removeFilmToRealisateur(int realisateurId, int filmId) {
		Realisateur realisateur = em.find(Realisateur.class, realisateurId);
		Film film  = em.find(Film.class, filmId);
		if(realisateur == null || film == null) {
			return false;		
		}
		
		realisateur.getFilms().remove(film);
		return true;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Realisateur> findRealisateurNotFilm(int realisateurid) {
		return em.createQuery("FROM Realisateur",Realisateur.class).getResultList();
	}

	
//	@Override
//	@Transactional
//	public List<Realisateur> findAll() {
//		return em.createQuery("FROM Realisateur",Realisateur.class).getResultList();
//	}


	

}
