package com.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.model.Catalog;
import com.demo.model.Movie;
import com.demo.model.Rating;
import com.demo.model.UserRating;

@Controller
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder builder;

	@RequestMapping("/{userId}")
	@ResponseBody
	public List<Catalog> getCatalog(@PathVariable String userId) {
		
		
		UserRating userRatings = template.getForObject("http://movie-ratings-service/ratings/users/"+userId, UserRating.class);
		List<Rating> ratings = userRatings.getRatings();
		
		return ratings.stream().map(rating -> {
			
			// RestTemplate
//			Movie movie = template.getForObject("http://localhost:8082/movies/" + rating.getGameId(), Movie.class);
			
			// WebClient
			Movie movie = builder.build()
			.get()
			.uri("http://movie-info-service/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			
			return new Catalog(1L, movie.getName(), movie.getDescription(), rating.getRate());
			
		}).collect(Collectors.toList());

//		return Collections.singletonList(new Catalog(1L, "Catalog 1", "Description 1", 4.0));
	}
}
