package com.edugroup.exercicesecurity.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.exercicesecurity.metier.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
