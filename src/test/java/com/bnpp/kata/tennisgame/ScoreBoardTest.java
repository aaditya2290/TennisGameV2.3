package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ScoreBoardTest {

	private static final String ADVANTAGE = "Advantage ";
	private static final String DEUCE = "Deuce";
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

	@Test
	public void scoreBoardShouldDisplayFifteenAllIfBothPlayersWinOnePoint() {
		firstPlayer.setPoints(1);
		secondPlayer.setPoints(1);
		scoreBoard.updateGamePoints();
		assertThat(scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Fifteen All")));
	}

	@Test
	public void scoreBoardShouldDisplayThirtyFortyIfFirstPlayerWinsTwoPointsAndSecondPlayerWinsThreePoints() {
		firstPlayer.setPoints(2);
		secondPlayer.setPoints(3);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Thirty Forty")));
	}

	@Test
	public void scoreBoardShouldDisplayDeuceIfBothPlayersWinThreePoints() {
		firstPlayer.setPoints(3);
		secondPlayer.setPoints(3);
		scoreBoard.updateGamePoints();
		assertThat(scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, DEUCE)));
	}

	@Test
	public void scoreBoardShouldDisplayDeuceIfBothPlayersWinSevenPoints() {
		firstPlayer.setPoints(7);
		secondPlayer.setPoints(7);
		scoreBoard.updateGamePoints();
		assertThat(scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, DEUCE)));
	}

	@Test
	public void scoreBoardShouldDisplayAdvantageFirstPlayerIfFirstPlayerWinsFourPointsAndSecondPlayerWinsThreePoints() {
		firstPlayer.setPoints(4);
		secondPlayer.setPoints(3);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, ADVANTAGE
						+ firstPlayer.getName())));
	}

	@Test
	public void scoreBoardShouldDisplayAdvantageSecondPlayerIfFirstPlayerWinsTenPointsAndSecondPlayerWinsElevenPoints() {
		firstPlayer.setPoints(10);
		secondPlayer.setPoints(11);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, ADVANTAGE
						+ secondPlayer.getName())));
	}

	@Test
	public void scoreBoardShouldDisplayFirstPlayerWinsIfFirstPlayerWinsSevenPointsAndSecondPlayerWinsFivePoints() {
		firstPlayer.setPoints(7);
		secondPlayer.setPoints(5);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer,
						firstPlayer.getName() + " Wins")));
	}

	@Test
	public void scoreBoardShouldDisplaySecondPlayerWinsIfFirstPlayerWinsOnePointAndSecondPlayerWinsFourPoints() {
		firstPlayer.setPoints(1);
		secondPlayer.setPoints(4);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer,
						secondPlayer.getName() + " Wins")));
	}

	@Test
	public void scoreBoardShouldDisplayPlayerPointsAreInvalidIfFirstPlayerWinsSixPointsAndSecondPlayerWinsOnePoint() {
		firstPlayer.setPoints(6);
		secondPlayer.setPoints(1);
		scoreBoard.updateGamePoints();
		assertThat(
				scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer,
						"Player points are invalid")));
	}

	private String displayScoreBoard(Player firstPlayer, Player secondPlayer,
			String gameResult) {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), String.valueOf(firstPlayer.getPoints()),
				secondPlayer.getName(),
				String.valueOf(secondPlayer.getPoints()), "Result", gameResult };
		String displayResult = "\n";
		for (int scoreIndex = 0; scoreIndex <= scoreBoardContents.length - 1; scoreIndex += 2) {
			displayResult += String.format("|%1$-25s|%2$-25s|",
					scoreBoardContents[scoreIndex],
					scoreBoardContents[scoreIndex + 1])
					+ "\n";
		}
		return displayResult;
	}
}
