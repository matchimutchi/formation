package com.edugroup.myinjection.repositories;

import java.util.List;

import com.edugroup.myinjection.metier.Lecture;

public interface JDBCLivreRepositoryInterface {

	List<Lecture> findByTitre(String searchterm);
	int updateEmail(String email, int userId);

}