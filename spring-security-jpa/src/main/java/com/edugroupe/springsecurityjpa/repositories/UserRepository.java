package com.edugroupe.springsecurityjpa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springsecurityjpa.metier.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	User findByUsername(String username);
}
