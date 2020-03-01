package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TennisGameTest {

	@Test
	public void tennisGameShouldHaveTwoPlayers() {
		Player firstPlayer = new Player("Sampras");
		Player secondPlayer = new Player("Agassi");
		TennisGame tennisGame = new TennisGame(firstPlayer, secondPlayer);

		assertThat(tennisGame.getFirstPlayer(), isA(Player.class));
		assertThat(tennisGame.getSecondPlayer(), isA(Player.class));
		assertThat(tennisGame.getFirstPlayer().getName(), isA(String.class));
		assertThat(tennisGame.getSecondPlayer().getName(), isA(String.class));
	}

}
