package com.edugroupe.springuploadrepbase.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroupe.springuploadrepbase.metier.Picture;

public interface PictureRepository extends PagingAndSortingRepository<Picture, Long>, PictureRepositoryCustom {

}
