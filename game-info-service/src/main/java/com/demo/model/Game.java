package com.demo.model;

public class Game {

	private Long id;
	private String name;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
