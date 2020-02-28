package com.edugroup.securityandoauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edugroup.securityandoauth.metier.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
