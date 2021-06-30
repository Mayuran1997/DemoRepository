package com.microservices.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.moviecatalogservice.model.CatalogItem;
import com.microservices.moviecatalogservice.model.MovieInfo;
import com.microservices.moviecatalogservice.model.Rating;
import com.microservices.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*@Autowired
	private WebClient.Builder wb;*/
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		
		
		UserRating userRating=restTemplate.getForObject("http://ratingsdata-service/ratingdata/users/"+userId, UserRating.class);
				
		return userRating.getRatings().stream().map(rating->{
			//for each movieid ,call movie info and get the details
			MovieInfo movie= restTemplate.getForObject("http://movieinfo-service/movies/"+rating.getMovieId(), MovieInfo.class);
			//put ratings plus movie info together
			return new CatalogItem(movie.getName(), "Action", rating.getRating());
		})
				.collect(Collectors.toList());
		/*return Collections.singletonList(
				new CatalogItem("Beast", "Action", 4)
				);*/
	}
	
	/*MovieInfo movie=wb.build()
	.get()
	.uri("http://localhost:8081/movies/"+rating.getMovieId())
	.retrieve()
	.bodyToMono(MovieInfo.class)
	.block();*/
	
}
