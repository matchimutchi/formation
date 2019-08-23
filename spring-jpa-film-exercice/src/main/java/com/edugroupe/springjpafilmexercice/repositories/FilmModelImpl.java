package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;
import com.edugroupe.springjpafilmexercice.metier.Film;
import com.edugroupe.springjpafilmexercice.metier.Realisateur;



@Service
public class FilmModelImpl implements FilmModel {

	@PersistenceContext
	public EntityManager em;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Film> findAll(boolean withGenre){
			if(withGenre) {
				return em.createQuery("SELECT DISTINCT(f) FROM Film as f LEFT JOIN fetch f.acteurs",Film.class).getResultList();
			}else{
				return em.createQuery("FROM Film",Film.class).getResultList();
			}
		

	}

	
	@Override
	@Transactional(readOnly = true)
	public Film findById(int id) {
		return em.find(Film.class, id);
	}
	
	@Override
	@Transactional
	public Film save(Film film,int realisateurId) {
		
		Realisateur r = em.find(Realisateur.class,realisateurId);
		film.setRealisateur(r);
		
		if(film.getId() == 0) {
			em.persist(film);
		}else {
			Film oldLivre = em.find(Film.class,film.getId());
			film.setActeurs(oldLivre.getActeurs());
			film = em.merge(film);
		}
		return film;
	
	}
	
	@Override
	@Transactional
	public boolean deleteById(int id) {
		Film f = em.find(Film.class, id);
		if(f == null)
			return false;
		em.remove(f);
		return true;
				
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Acteur> findFilmActeur(int filmId){
		TypedQuery<Acteur> q = em.createQuery("SELECT a FROM Acteur as a JOIN a.films as f WHERE f.id = :filmId",Acteur.class);
		q.setParameter("filmId", filmId);
		return q.getResultList();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Acteur> findFilmNotActeur(int filmId){
		TypedQuery<Acteur> q = em.createQuery("SELECT a FROM Acteur AS a WHERE NOT EXISTS(SELECT f FROM Film AS f JOIN f.acteurs AS a2 WHERE f.id = :filmId AND a2.id = a.id)",Acteur.class);
		q.setParameter("filmId", filmId);
		return q.getResultList();
	}
	
	@Override
	@Transactional
	public boolean addActeurToFilm(int filmId, int acteurId) {
		Film film = em.find(Film.class, filmId);
		Acteur acteur  = em.find(Acteur.class, acteurId);
		if(film == null || acteur == null) {
			return false;		
		}
		
		film.getActeurs().add(acteur);
		return true;
	}
	
	@Override
	@Transactional
	public boolean removeActeurToFilm(int filmId, int acteurId) {
		Film film = em.find(Film.class, filmId);
		Acteur acteur  = em.find(Acteur.class, acteurId);
		if(film == null || acteur == null) {
			return false;		
		}
		
		film.getActeurs().remove(acteur);
		return true;
	}





	
	
	
}
