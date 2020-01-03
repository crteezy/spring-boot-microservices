package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Movie;

@Controller
@RequestMapping("/movies")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	@ResponseBody
	public Movie getGameInfo(@PathVariable("movieId") Long id){
		return new Movie(id, "BattleField 1");
	}
}
