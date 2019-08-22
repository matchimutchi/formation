package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;
import com.edugroupe.springjpafilmexercice.metier.Film;

public interface FilmModel {

	List<Film> findAll();

	boolean removeActeurToFilm(int filmId, int acteurId);

	boolean addActeurToFilm(int filmId, int acteurId);

	List<Acteur> findFilmNotActeur(int filmId);

	Film findById(int id);

	Film save(Film film, int realisateurId);

	List<Acteur> findFilmActeur(int filmId);

	boolean deleteById(int id);

}