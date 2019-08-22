package com.edugroupe.springjpafnak.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafnak.metier.Genre;
import com.edugroupe.springjpafnak.metier.Livre;

public interface LivreModel {


	Livre findById(int id);

	List<Livre> findAll(boolean withGenre);

	Livre save(Livre livre, int auteurId);

	boolean deleteById(int id);

	List<Genre> findLivreGenre(int livreId);

	List<Genre> findLivreNotGenre(int livreId);

	boolean addGenreToLivre(int livreId, int genreId);

	boolean removeGenreToLivre(int livreId, int genreId);



}