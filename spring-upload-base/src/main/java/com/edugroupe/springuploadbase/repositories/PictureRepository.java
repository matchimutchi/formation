package com.edugroupe.springuploadbase.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.edugroupe.springuploadbase.metier.Picture;
import com.edugroupe.springuploadbase.metier.projections.PictureWithoutFile;

public interface PictureRepository extends PagingAndSortingRepository<Picture, Integer> {

	@Query("select new "
			+ "com.edugroupe.springuploadbase.metier.projections.PictureWithoutFile"
			+ "(p.id, p.titre, p.fileName, p.contentType)"
			+ " From Picture as p")
	public Page<PictureWithoutFile> findAllWithoutFile(Pageable page);

	
	@Query("select new "
			+ "com.edugroupe.springuploadbase.metier.projections.PictureWithoutFile"
			+ "(p.id, p.titre, p.fileName, p.contentType)"
			+ " from Picture as p where p.id = :id")
	public PictureWithoutFile findWithoutFileById(@Param("id") int id);
}
