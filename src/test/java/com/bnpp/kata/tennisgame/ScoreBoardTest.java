package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ScoreBoardTest {

	private Player firstPlayer;
	private Player secondPlayer;
	private ScoreBoard scoreBoard;

	@Before
	public void setUp() {
		firstPlayer = new Player("Sampras");
		secondPlayer = new Player("Agassi");
		scoreBoard = new ScoreBoard(firstPlayer, secondPlayer);
	}

	@Test
	public void scoreBoardShouldDisplayLoveAllBeforeGameBegins() {
		assertThat(scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Love All")));
	}

	@Test
	public void scoreBoardShouldDisplayFifteenLoveIfFirstPlayerWinsOnePoint() {
		firstPlayer.setPoints(1);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Fifteen Love")));

	}

	@Test
	public void scoreBoardShouldDisplayLoveFifteenIfSecondPlayerWinsOnePoint() {
		secondPlayer.setPoints(1);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Love Fifteen")));

	}

	private String displayScoreBoard(Player firstPlayer, Player secondPlayer,
			String gameResult) {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), String.valueOf(firstPlayer.getPoints()),
				secondPlayer.getName(),
				String.valueOf(secondPlayer.getPoints()), "Result", gameResult };
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
