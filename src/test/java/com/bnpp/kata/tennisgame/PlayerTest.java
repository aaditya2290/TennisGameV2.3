package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	private Player tennisPlayer;

	@Before
	public void setUp() {
		tennisPlayer = new Player("Sampras");
	}

	@Test
	public void playerScoreShouldbeLoveIfPlayerDoesNotWinAnyPoints() {
		tennisPlayer = new Player("Sampras");
		assertThat(tennisPlayer.getScore(), is("Love"));
	}

	@Test
	public void playerScoreShouldbeFifteenIfPlayerWinsOnePoint() {
		tennisPlayer = new Player("Sampras");
		tennisPlayer.setPoints(1);
		assertThat(tennisPlayer.getScore(), is("Fifteen"));
	}

}
