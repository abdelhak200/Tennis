package it.yook.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

	private IGame game;
    private String playerOneName;
    private String playerTwoName;

    @Before
    public void setUp() throws Exception {
        playerOneName = "Player One";
        playerTwoName = "Player Two";
        
        
        game = new Game(new Player(playerOneName), new Player(playerTwoName));
    }

    @Test
    public void newGameScoreShouldBeLoveAll() {
        assertEquals("Love", game.resultOfMatch());
    }

    @Test
    public void whenPlayerOneWinsFirstBallScoreReturnsFifteenLove() throws Exception {
        setScore(1, 0);
        assertEquals("FifteenLove", game.resultOfMatch());
    }

    @Test
    public void whenAllPlayerScoresOnceScoreMustBeFifteenAll() throws Exception {
        setScore(1, 1);
        assertEquals("Fifteen", game.resultOfMatch());
    }

    @Test
    public void whenPlayerOneScoresTwiceScoreMustBeThirtyLove() throws Exception {
        setScore(2, 0);
        assertEquals("ThirtyLove", game.resultOfMatch());
    }

    @Test
    public void whenPlayerTwoScoresThreeTimesScoreMustBeLoveFourty() throws Exception {
        setScore(0, 3);
        assertEquals("LoveFourty", game.resultOfMatch());
    }

    @Test
    public void whenAllPlayersScoresThreeTimesScoreMustReturnDeuce() throws Exception {
        setScore(3, 3);
        assertEquals("DEUCE", game.resultOfMatch());
    }

    @Test
    public void whenPlayerOneScoresFourTimesThenPlayerOneWinsTheGame() throws Exception {
        setScore(4, 0);
        assertEquals(playerOneName + " wins", game.resultOfMatch());
    }

    @Test
    public void whenPlayerTwoScoresFourTimesThenPlayerTwoWinsTheGame() throws Exception {
        setScore(0, 4);
        assertEquals( playerTwoName +" wins", game.resultOfMatch());
    }

    @Test
    public void whenPlayersScoresFourTimesThenScoreMustBeDeuce() throws Exception {
        setScore(4, 4);
        assertEquals("DEUCE", game.resultOfMatch());
    }

    @Test
    public void whenPlayerOneHasAdvantageScoreShouldBeAdvantagePlayerOne() throws Exception {
        setScore(4, 3);
        assertEquals("Advantage " + playerOneName, game.resultOfMatch());
    }

    @Test
    public void whenPlayerTwoHasAdvantageScoreShouldBeAdvantagePlayerTwo() throws Exception {
        setScore(3, 4);
        assertEquals("Advantage " + playerTwoName, game.resultOfMatch());
    }

    @Test
    public void whenPlayerOneWinsFromAdvantage() throws Exception {
        setScore(5, 3);
        assertEquals(playerOneName + " wins", game.resultOfMatch());
    }

    @Test
    public void whenPlayerTwoWinsFromAdvantage() throws Exception {
        setScore(3, 5);
        assertEquals(playerTwoName + " wins", game.resultOfMatch());
    }

    private void setScore(int playerOneScore, int playerTwoScore) {
        for (int i = 0; i < playerOneScore; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoScore; i++) {
            game.playerTwoScores();
        }

}

	 
}
