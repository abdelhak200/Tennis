package it.yook.tennis;


public class Game implements IGame{
	
    private final String PLAYER_ONE_NAME;
    private final String PLAYER_TWO_NAME;

    private Player player1;
    private Player player2;
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public Game(Player player1, Player player2) {
    	
    	this.player1 = player1;
    	this.player2 = player2;
    	
    	this.player1.setScore(playerOneScore);
        this.player2.setScore(playerTwoScore);
        
    	this.PLAYER_ONE_NAME = player1.getPlayerName();
        this.PLAYER_TWO_NAME = player2.getPlayerName();
        
    }

    public void playerOneScores() {
    	playerOneScore++;
     	this.player1.setScore(playerOneScore);
    }

    public void playerTwoScores() {
    	playerTwoScore++;
    	this.player2.setScore(playerTwoScore);
    }

    public String resultOfMatch() {
        String score;
        if (isPlayerOneWinner()) {
            score = playerWins(player1);
        } else if (isPlayerTwoWinner()) {
            score = playerWins(player2);
        } else if (hasPlayerOneAdvantage()) {
            score = hasPlayerAdvantage(PLAYER_ONE_NAME);
        } else if (hasPlayerTwoAdvantage()) {
            score = hasPlayerAdvantage(PLAYER_TWO_NAME);
        } else if (isDeuce()) {
            score = "DEUCE";
        } else {
            score = getRegularScore();
        }
        return score;
    }

    public boolean isPlayerOneWinner() {
        return playerOneScore > playerTwoScore + 1 && playerOneScore > 3;
    }

    public boolean isPlayerTwoWinner() {
        return playerTwoScore > playerOneScore + 1 && playerTwoScore > 3;
    }

    public boolean hasPlayerOneAdvantage() {
        return playerOneScore == playerTwoScore + 1 && playerOneScore > 3;
    }
    
    public String playerWins(Player player) {
    	return player.getPlayerName()+" wins";
    }

    public boolean hasPlayerTwoAdvantage() {
        return playerTwoScore == playerOneScore + 1 && playerTwoScore > 3;
    }

    public String hasPlayerAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    public boolean isDeuce() {
    	return playerOneScore == playerTwoScore && playerOneScore >= 3;
    }

    public Player getLeadPlayer() {
    	return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }
    
    public String getRegularScore() {
        return playerOneScore == playerTwoScore ? getScoreStringWhenEqualityScores() : getScoreStringWhenDifferentScores();
    }

    public String getScoreStringWhenEqualityScores() {
        return Points.getScore(playerOneScore);
    }

    public String getScoreStringWhenDifferentScores() {
        return Points.getScore(playerOneScore)+ Points.getScore(playerTwoScore);
  }
    
}