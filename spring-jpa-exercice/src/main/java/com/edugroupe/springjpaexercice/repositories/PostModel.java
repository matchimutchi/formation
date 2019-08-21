package com.edugroupe.springjpaexercice.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpaexercice.metier.Post;

public interface PostModel {

	List<Post> findAll();

	Post findById(int id);

	Post save(Post p);

	boolean deleteById(int id);

	List<Post> search(String nom);

	List<Post> searchDate(LocalDate date);

}