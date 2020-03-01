package com.bnpp.kata.tennisgame;

public class ScoreBoard {

	private static final String ZERO_STRING_VALUE = String.valueOf(0);
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

	@Override
	public String toString() {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), ZERO_STRING_VALUE,
				secondPlayer.getName(), ZERO_STRING_VALUE, "Result", "Love All" };
		String displayResult = new String();
		for (int scoreIndex = 0; scoreIndex <= scoreBoardContents.length - 1; scoreIndex += 2) {
			displayResult += String.format("|%1$-25s|%2$-25s|",
					scoreBoardContents[scoreIndex],
					scoreBoardContents[scoreIndex + 1])
					+ "\n";
		}
		return displayResult;
	}


}
