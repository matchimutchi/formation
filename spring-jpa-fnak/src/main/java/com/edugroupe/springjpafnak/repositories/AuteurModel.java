package com.edugroupe.springjpafnak.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafnak.metier.Auteur;

public interface AuteurModel {

	List<Auteur> findAll();

	//boolean deleteById(int id);

}