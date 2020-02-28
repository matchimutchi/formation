package com.edugroup.springbootfirstgridfs.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.springbootfirstgridfs.metier.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Integer> {

}
