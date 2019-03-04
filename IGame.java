package it.yook.tennis;

public interface IGame {
	
	public void playerOneScores();
	public void playerTwoScores();
	public String resultOfMatch() ;
	public boolean isPlayerOneWinner();
	public boolean isPlayerTwoWinner() ;
	
	public String playerWins(Player player) ;

	public boolean hasPlayerOneAdvantage();
	public boolean hasPlayerTwoAdvantage() ;
	public String hasPlayerAdvantage(String playerName);
	
	public boolean isDeuce() ;
	public String getRegularScore() ;

	public String getScoreStringWhenEqualityScores() ;
	public String getScoreStringWhenDifferentScores();

}
