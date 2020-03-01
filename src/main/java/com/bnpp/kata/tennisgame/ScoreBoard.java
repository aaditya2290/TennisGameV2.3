package com.bnpp.kata.tennisgame;

public class ScoreBoard {

	private Player firstPlayer;
	private Player secondPlayer;

	public ScoreBoard(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

}
