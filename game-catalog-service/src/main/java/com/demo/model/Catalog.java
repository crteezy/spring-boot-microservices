package com.demo.model;

public class Catalog {

	private Long id;
	private String name;
	private String description;
	private double rating;

	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	public Catalog(Long id, String name, String description, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
