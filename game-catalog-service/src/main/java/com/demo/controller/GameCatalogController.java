package com.demo.controller;

import java.util.Arrays;
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
import com.demo.model.Game;
import com.demo.model.Rating;

@Controller
@RequestMapping("/catalog")
public class GameCatalogController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private WebClient.Builder builder;

	@RequestMapping("/{userId}")
	@ResponseBody
	public List<Catalog> getCatalog(@PathVariable String userId) {
		
		
		List<Rating> ratings = Arrays.asList(
				new Rating(1L, 1L, 4.5),
				new Rating(2L, 2L, 4.0)
		);
		
		return ratings.stream().map(rating -> {
			
			// RestTemplate
//			Game game = template.getForObject("http://localhost:8082/games/" + rating.getGameId(), Game.class);
			
			// WebClient
			Game game = builder.build()
			.get()
			.uri("http://localhost:8082/games/" + rating.getGameId())
			.retrieve()
			.bodyToMono(Game.class)
			.block();
			
			return new Catalog(1L, game.getName(), "Desc", rating.getRate());
			
		}).collect(Collectors.toList());

//		return Collections.singletonList(new Catalog(1L, "Catalog 1", "Description 1", 4.0));
	}
}
