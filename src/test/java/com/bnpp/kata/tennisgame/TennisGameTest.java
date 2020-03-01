package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private Player firstPlayer;
	private Player secondPlayer;
	private TennisGame tennisGame;

	@Before
	public void setUp() {
		firstPlayer = new Player("Sampras");
		secondPlayer = new Player("Agassi");
		tennisGame = new TennisGame(firstPlayer, secondPlayer);
	}

	@Test
	public void tennisGameShouldHaveTwoPlayers() {
		Player tennisGameFirstPlayer = tennisGame.getFirstPlayer();
		Player tennisGameSecondPlayer = tennisGame.getSecondPlayer();

		assertThat(tennisGameFirstPlayer, isA(Player.class));
		assertThat(tennisGameSecondPlayer, isA(Player.class));
		assertThat(tennisGameFirstPlayer.getName(), isA(String.class));
		assertThat(tennisGameSecondPlayer.getName(), isA(String.class));
	}

	@Test
	public void tennisGameShouldHaveAScoreBoardForPlayers() {
		ScoreBoard tennisGameScoreBoard = tennisGame.getScoreBoard();

		assertThat(tennisGameScoreBoard, isA(ScoreBoard.class));
		assertThat(tennisGameScoreBoard.getFirstPlayer(), is(firstPlayer));
		assertThat(tennisGameScoreBoard.getSecondPlayer(), is(secondPlayer));
	}

}
