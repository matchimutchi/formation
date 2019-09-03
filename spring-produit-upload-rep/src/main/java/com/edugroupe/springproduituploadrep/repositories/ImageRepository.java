package com.edugroupe.springproduituploadrep.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springproduituploadrep.metier.Image;


public interface ImageRepository extends PagingAndSortingRepository<Image, Integer>,ImageRepositoryCustom{

}
