package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Rating;
import com.demo.model.UserRating;

@Controller
@RequestMapping("/ratings")
public class RatingsController {

	@RequestMapping("/{movieId}")
	@ResponseBody
	public Rating getRating(@PathVariable("movieId") Long movieId) {
		return new Rating(1L, movieId, 4.5);
	}

	@RequestMapping("/users/{userId}")
	@ResponseBody
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating(1L, 1L, 4.5),
				new Rating(2L, 2L, 4.0)
		);

		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);

		return userRating;
	}
}
