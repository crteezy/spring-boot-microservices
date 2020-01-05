package com.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Rating;
import com.demo.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfoService {

	@Autowired
	private RestTemplate template;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		return template.getForObject("http://movie-ratings-service/ratings/users/"+userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(String userId) {
		UserRating ur = new UserRating();
		ur.setUserId(userId);
		ur.setRatings(Arrays.asList(new Rating(0L, 0L, 0)));
		return ur;
	}
}
