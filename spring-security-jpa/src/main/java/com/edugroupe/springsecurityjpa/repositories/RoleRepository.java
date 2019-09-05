package com.edugroupe.springsecurityjpa.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springsecurityjpa.metier.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
	Role findByRoleName(String roleName);
}
