package com.edugroupe.springlivrerestexercice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springlivrerestexercice.metier.User;



public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	User findByUsername(String userName);
}
