package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;
import com.edugroupe.springjpafilmexercice.metier.Film;

public interface FilmModel {

	//List<Film> findAll();
	Film findById(int id);
	
	List<Film> findAll(boolean withGenre);
	
	Film save(Film film, int realisateurId);
	
	boolean deleteById(int id);
	
	List<Acteur> findFilmActeur(int filmId);
	
	List<Acteur> findFilmNotActeur(int filmId);

	boolean removeActeurToFilm(int filmId, int acteurId);

	boolean addActeurToFilm(int filmId, int acteurId);


	

	



}