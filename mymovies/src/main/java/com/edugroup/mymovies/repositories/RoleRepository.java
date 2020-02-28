package com.edugroup.mymovies.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.mymovies.metier.Role;


public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {

}
