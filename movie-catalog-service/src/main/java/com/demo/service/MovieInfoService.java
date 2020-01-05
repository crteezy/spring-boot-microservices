package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.model.Catalog;
import com.demo.model.Movie;
import com.demo.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfoService {

	@Autowired
	private WebClient.Builder builder;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public Catalog getCatalogItem(Rating rating) {
		// RestTemplate
		// Movie movie = template.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
		
		// WebClient
		Movie movie = builder.build()
		.get()
		.uri("http://movie-info-service/movies/" + rating.getMovieId())
		.retrieve()
		.bodyToMono(Movie.class)
		.block();
		
		return new Catalog(1L, movie.getName(), movie.getDescription(), rating.getRate());
	}
	
	public Catalog getFallbackCatalogItem(Rating rating) {
		return new Catalog(0L, "Not Found", "Movie Not Found", rating.getRate());
	}
}
