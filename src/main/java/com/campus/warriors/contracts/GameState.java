 package com.campus.warriors.contracts;

public interface GameState {
/**
	 * @return the player name
	 */
	String getPlayerName();
	
	/**
	 * @return the game unique ID
	 */
	String getGameId();
	
	/**
	 * @return the game status 
	 */
	GameStatus getGameStatus();
	
	/**
	 * @return the current hero
	 */
	Hero getHero();
	
	/**
	 * @return the current map
	 */
	Map getMap();
	
	/**
	 * @return the last log of the game. This log is displayed by the client after each game turn
	 */
	String getLastLog();
	
	/**
	 * @return the current case
	 */
	int getCurrentCase(); 
}
