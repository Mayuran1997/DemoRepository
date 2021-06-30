package com.microservices.Ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.Ratingsdataservice.model.Rating;
import com.microservices.Ratingsdataservice.model.UserRating;



@RestController
@RequestMapping("/ratingdata")
public class RatingsDataController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId,7);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getListofRating(@PathVariable String userId) {
		List<Rating> ratings=Arrays.asList(
				new Rating("1", 4),			
				new Rating("2", 5)
				);
		UserRating ur= new UserRating();
				ur.setRatings(ratings);
		return ur;
	}

}
