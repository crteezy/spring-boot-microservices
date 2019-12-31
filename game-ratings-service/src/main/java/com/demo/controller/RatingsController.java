package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Rating;

@Controller
@RequestMapping("/ratings")
public class RatingsController {

	@RequestMapping("/{gameId}")
	@ResponseBody
	public Rating getRating(@PathVariable("gameId") Long gameId) {
		return new Rating(1L, gameId, 4.5);
	}
}
