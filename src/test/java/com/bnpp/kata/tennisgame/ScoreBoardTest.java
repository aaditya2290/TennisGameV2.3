package com.bnpp.kata.tennisgame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScoreBoardTest {

	@Test
	public void scoreBoardShouldDisplayLoveAllBeforeGameBegins() {

		Player firstPlayer = new Player("Sampras");
		Player secondPlayer = new Player("Agassi");
		ScoreBoard scoreBoard = new ScoreBoard(firstPlayer, secondPlayer);
		assertThat(scoreBoard.toString(),
				is(displayScoreBoard(firstPlayer, secondPlayer, "Love All")));
	}

	private String displayScoreBoard(Player firstPlayer, Player secondPlayer,
			String gameResult) {
		String[] scoreBoardContents = { "Player Names", "Points",
				firstPlayer.getName(), String.valueOf(0),
				secondPlayer.getName(), String.valueOf(0), "Result", gameResult };
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