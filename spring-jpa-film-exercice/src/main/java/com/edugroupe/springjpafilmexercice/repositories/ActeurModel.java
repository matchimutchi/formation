package com.edugroupe.springjpafilmexercice.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafilmexercice.metier.Acteur;
import com.edugroupe.springjpafilmexercice.metier.Film;

public interface ActeurModel {

	List<Acteur> findAll();

	Acteur findById(int id);

	Acteur save(Acteur acteur);

	boolean deleteById(int id);

	

}