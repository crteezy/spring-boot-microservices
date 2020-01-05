package com.demo.controller;

import java.util.Arrays;
import java.util.Collections;
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
import com.demo.service.MovieInfoService;
import com.demo.service.UserRatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@RequestMapping("/catalog")
public class MovieCatalogController {
	
//	@Autowired
//	private RestTemplate template;
//	
//	@Autowired
//	private WebClient.Builder builder;
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	@Autowired
	private UserRatingInfoService userRatingInfoService;

	@RequestMapping("/{userId}")
	@ResponseBody
//	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<Catalog> getCatalog(@PathVariable String userId) {
		
		UserRating userRatings = userRatingInfoService.getUserRating(userId);
		List<Rating> ratings = userRatings.getRatings();
		
		return ratings.stream().map(rating -> {
			return movieInfoService.getCatalogItem(rating);
		}).collect(Collectors.toList());

		// return Collections.singletonList(new Catalog(1L, "Catalog 1", "Description 1", 4.0));
	}
}
