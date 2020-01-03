package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Movie;
import com.demo.model.MovieSummary;

@Controller
@RequestMapping("/movies")
public class MovieInfoController {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate template;

	@RequestMapping("/{movieId}")
	@ResponseBody
	public Movie getMovieInfo(@PathVariable("movieId") Long id){
//		return new Movie(id, "BattleField 1");
		
		MovieSummary movieSummary = template.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey, MovieSummary.class);
		Movie movie = new Movie(movieSummary.getId(), movieSummary.getTitle(), movieSummary.getOverview());
		
		return movie;
	}
}
