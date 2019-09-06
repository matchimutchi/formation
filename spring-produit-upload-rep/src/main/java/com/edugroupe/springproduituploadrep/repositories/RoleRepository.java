package com.edugroupe.springproduituploadrep.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
	Role findByRoleName(String roleName);
}
