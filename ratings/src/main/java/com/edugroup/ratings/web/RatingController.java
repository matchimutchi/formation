package com.edugroup.ratings.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edugroup.ratings.metier.Rating;
import com.edugroup.ratings.repositories.RatingRepository;

@RestController
@RequestMapping("/ratings")
@CrossOrigin
public class RatingController {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@GetMapping("/{userId:[a-zA-Z0-9]+}")
	public List<Rating> findByUserId(@PathVariable("userId") String userId){
		return ratingRepository.findByUserId(userId);
	}
}
