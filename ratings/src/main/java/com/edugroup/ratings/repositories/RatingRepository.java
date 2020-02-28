package com.edugroup.ratings.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edugroup.ratings.metier.Rating;

public interface RatingRepository extends PagingAndSortingRepository<Rating, Integer> {

	List<Rating> findByUserId(String userId);
}
