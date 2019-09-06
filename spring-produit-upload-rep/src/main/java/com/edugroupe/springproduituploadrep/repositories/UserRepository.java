package com.edugroupe.springproduituploadrep.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.User;


public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	User findByUsername(String userName);
}
