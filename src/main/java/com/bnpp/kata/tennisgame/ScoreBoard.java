package com.bnpp.kata.tennisgame;

public class ScoreBoard {

	private Player firstPlayer;
	private Player secondPlayer;
	private String boardResult;

	public ScoreBoard(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.boardResult = "Love All";
	}

	public void updateGamePoints() {
		if (firstPlayer.compareTo(secondPlayer) == 0) {
			boardResult = firstPlayer.getScore() + " All";
		} else {
			boardResult = firstPlayer.getScore() + " "
					+ secondPlayer.getScore();
		}
	}

	@Override
	public String toString() {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), String.valueOf(firstPlayer.getPoints()),
				secondPlayer.getName(),
				String.valueOf(secondPlayer.getPoints()), "Result", boardResult };
		String displayResult = new String();
		for (int scoreIndex = 0; scoreIndex <= scoreBoardContents.length - 1; scoreIndex += 2) {
			displayResult += String.format("|%1$-25s|%2$-25s|",
					scoreBoardContents[scoreIndex],
					scoreBoardContents[scoreIndex + 1])
					+ "\n";
		}
		return displayResult;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

}
