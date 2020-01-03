package com.demo.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {

	private String userId;
	private List<Rating> ratings;

	public UserRating() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> userRatings) {
		this.ratings = userRatings;
	}
	
	public void initData(String userId) {
		this.setUserId(userId);
		this.setRatings(Arrays.asList(
				new Rating(1L, 62L, 4.5),
				new Rating(2L, 500L, 4.0)
		));
	}
}
