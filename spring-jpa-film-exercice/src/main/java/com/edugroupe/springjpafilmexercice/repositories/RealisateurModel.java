package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Film;
import com.edugroupe.springjpafilmexercice.metier.Realisateur;

public interface RealisateurModel {

//	List<Realisateur> findAll();
	
	List<Realisateur> findAll(boolean withFilm);
	
	Realisateur findById(int id);

	boolean deleteById(int id);

	Realisateur save(Realisateur Realisateur);

	List<Film> findRealisateurFilm(int realisateurid);

	List<Realisateur> findRealisateurNotFilm(int realisateurid);

	boolean addFilmToRealisateur(int realisateurId, int filmId);

	boolean removeFilmToRealisateur(int realisateurId, int filmId);



	

	

	

}