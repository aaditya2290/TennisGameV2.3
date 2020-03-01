package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.constants.PointsToScoreMapper;

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

	public String getScore() {
		return PointsToScoreMapper.getScore(points);
	}

}
