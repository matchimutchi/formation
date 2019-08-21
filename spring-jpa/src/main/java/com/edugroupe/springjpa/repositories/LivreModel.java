package com.edugroupe.springjpa.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpa.metier.Livre;

public interface LivreModel {

	List<Livre> findAll();

	Livre findById(int id);

	Livre save(Livre l);

	boolean deleteById(int id);

}