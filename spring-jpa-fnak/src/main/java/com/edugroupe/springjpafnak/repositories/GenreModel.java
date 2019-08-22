package com.edugroupe.springjpafnak.repositories;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpafnak.metier.Genre;

public interface GenreModel {

	List<Genre> findAll();

}