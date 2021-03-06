package com.bnpp.kata.tennisgame;

public class TennisGame {

	private Player firstPlayer;
	private Player secondPlayer;
	private ScoreBoard scoreBoard;

	public TennisGame(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.scoreBoard = new ScoreBoard(firstPlayer, secondPlayer);
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

}
