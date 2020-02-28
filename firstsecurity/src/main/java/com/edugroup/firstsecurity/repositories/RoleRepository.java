package com.edugroup.firstsecurity.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.firstsecurity.metier.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
