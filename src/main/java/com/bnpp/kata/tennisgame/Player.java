package com.bnpp.kata.tennisgame;

public class Player {

	private String name;
	private int points;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

}
