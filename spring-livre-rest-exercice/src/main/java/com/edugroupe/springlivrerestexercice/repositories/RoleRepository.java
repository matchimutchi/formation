package com.edugroupe.springlivrerestexercice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springlivrerestexercice.metier.Role;



public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
	Role findByRoleName(String roleName);
}
