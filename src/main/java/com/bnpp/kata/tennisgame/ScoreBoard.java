package com.bnpp.kata.tennisgame;

import com.bnpp.kata.tennisgame.exceptions.InvalidPointsException;

public class ScoreBoard {

	private static final String LOVE_ALL = "Love All";
	private static final int MINIMUM_POINTS_DIFFERENCE_FOR_WIN = 2;
	private static final int MINIMUM_POINTS_FOR_WIN = 4;
	private static final int POINTS_DIFFERENCE_FOR_ADVANTAGE = 1;
	private static final int MINIMUM_POINTS_FOR_DEUCE = 3;
	private Player firstPlayer;
	private Player secondPlayer;
	private String boardResult;

	public ScoreBoard(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.boardResult = LOVE_ALL;
	}

	public void updateGamePoints() {
		try {
			int playerPointsCompared = firstPlayer.compareTo(secondPlayer);
			int playerPointsDifference = Math.abs(playerPointsCompared);

			boolean isWin = (firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_WIN || secondPlayer
					.getPoints() >= MINIMUM_POINTS_FOR_WIN)
					&& playerPointsDifference >= MINIMUM_POINTS_DIFFERENCE_FOR_WIN;

			boolean isAdvantage = firstPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE
					&& secondPlayer.getPoints() >= MINIMUM_POINTS_FOR_DEUCE
					&& playerPointsDifference == POINTS_DIFFERENCE_FOR_ADVANTAGE;

			boolean isInvalid = (firstPlayer.getPoints() > MINIMUM_POINTS_FOR_WIN || secondPlayer
					.getPoints() > MINIMUM_POINTS_FOR_WIN)
					&& playerPointsDifference > MINIMUM_POINTS_DIFFERENCE_FOR_WIN;

			if (isInvalid) {
				throw new InvalidPointsException("Player points are invalid");
			} else if (isWin) {
				boardResult = ((playerPointsCompared > 0) ? firstPlayer
						.getName() : secondPlayer.getName()) + " Wins";
			} else if (isAdvantage) {
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
		} catch (InvalidPointsException e) {
			boardResult = e.getMessage();
		}
	}

	@Override
	public String toString() {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), String.valueOf(firstPlayer.getPoints()),
				secondPlayer.getName(),
				String.valueOf(secondPlayer.getPoints()), "Result", boardResult };
		String displayResult = "\n";
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
