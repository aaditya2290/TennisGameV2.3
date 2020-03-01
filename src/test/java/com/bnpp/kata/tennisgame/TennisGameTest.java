package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TennisGameTest {

	@Test
	public void tennisGameShouldHaveTwoPlayers() {
		Player firstPlayer = new Player("Sampras");
		Player secondPlayer = new Player("Agassi");
		TennisGame tennisGame = new TennisGame(firstPlayer, secondPlayer);

		Player tennisGameFirstPlayer = tennisGame.getFirstPlayer();
		Player tennisGameSecondPlayer = tennisGame.getSecondPlayer();

		assertThat(tennisGameFirstPlayer, isA(Player.class));
		assertThat(tennisGameSecondPlayer, isA(Player.class));
		assertThat(tennisGameFirstPlayer.getName(), isA(String.class));
		assertThat(tennisGameSecondPlayer.getName(), isA(String.class));
	}

	@Test
	public void tennisGameShouldHaveAScoreBoardForPlayers() {
		Player firstPlayer = new Player("Sampras");
		Player secondPlayer = new Player("Agassi");
		TennisGame tennisGame = new TennisGame(firstPlayer, secondPlayer);

		ScoreBoard tennisGameScoreBoard = tennisGame.getScoreBoard();

		assertThat(tennisGameScoreBoard, isA(ScoreBoard.class));
		assertThat(tennisGameScoreBoard.getFirstPlayer(), is(firstPlayer));
		assertThat(tennisGameScoreBoard.getSecondPlayer(), is(secondPlayer));
	}

}
