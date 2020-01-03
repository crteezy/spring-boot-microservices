package com.demo.model;

public class Rating {

	private Long id;
	private Long movieId;
	private double rate;

	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Rating(Long id, Long movieId, double rate) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
