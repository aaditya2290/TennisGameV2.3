package com.bnpp.kata.tennisgame;

public class ScoreBoard {

	private static final int POINTS_DIFFERENCE_FOR_ADVANTAGE = 1;
	private static final int MINIMUM_POINTS_FOR_DEUCE = 3;
	private Player firstPlayer;
	private Player secondPlayer;
	private String boardResult;

	public ScoreBoard(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.boardResult = "Love All";
	}

	public void updateGamePoints() {
		int playerPointsCompared = firstPlayer.compareTo(secondPlayer);

		if (firstPlayer.getPoints() >= 4 && playerPointsCompared >= 2) {
			boardResult = firstPlayer.getName() + " Wins";
		} else if (firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE
				&& secondPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE
				&& Math.abs(playerPointsCompared) == POINTS_DIFFERENCE_FOR_ADVANTAGE) {
			boardResult = "Advantage "
					+ ((playerPointsCompared > 0) ? firstPlayer.getName()
							: secondPlayer.getName());
		} else if (playerPointsCompared == 0) {
			boardResult = (firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE) ? "Deuce"
					: firstPlayer.getScore() + " All";
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
