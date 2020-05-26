package com.campus.warriors.engine;

import com.campus.warriors.contracts.GameState;
import com.campus.warriors.contracts.GameStatus;
import com.campus.warriors.contracts.Hero;
import com.campus.warriors.contracts.Map;
import com.campus.warriors.engine.maps.BaseMap;

/**
 * This interface describes the game state which should be return after each game turn
 */

public class Game implements GameState {

	String namePlayer;
	Hero chosenHero;
	BaseMap chosenMap;
	private String gameId;
	private int currentCase;
	GameStatus status;
	String lastLog;
	


	// constructeur
	public Game(String namePlayer, Hero chosenHero, BaseMap chosenMap, String gameId) {
		this.namePlayer = namePlayer;
		this.chosenHero = chosenHero;
		this.chosenMap = chosenMap;
		this.gameId = gameId;
		currentCase = 0;
		status = GameStatus.IN_PROGRESS;
		lastLog = "Bienvenue " + chosenHero.getName() + "!";
	}

	@Override
	public String getPlayerName() {

		return namePlayer;
	}

	@Override
	public String getGameId() {
		// TODO Auto-generated method stub
		return gameId;
	}

	@Override
	public GameStatus getGameStatus() {

		return status;
	}

	@Override
	public Hero getHero() {

		return chosenHero;
	}

	@Override
	public Map getMap() {

		return chosenMap;
	}

	@Override
	public String getLastLog() {

		return lastLog;
	}

	@Override
	public int getCurrentCase() {

		return currentCase;
	}

	public void setCurrentCase(int currentCase) {
		this.currentCase = currentCase;
	}
	//public void setLastLog(String lastLog) {
	//	this.lastLog = lastLog;
	//}

	public void moveHero(int count) {
		currentCase = currentCase + count;
		lastLog = "Vous avancez de " + count + " et vous êtes maintenant sur la case " + currentCase + " ! \n";

		if(currentCase >= chosenMap.getNumberOfCase()) {
			status = GameStatus.FINISHED;
			lastLog = "Vous avancez de " + count + " et vous avez maintenant terminé le jeu ! \n"
					+ "Félicitation pour cette belle VICTOIRE !";
		} else {
			Case positionCase = chosenMap.getListCase().get(currentCase);
			lastLog = "Vous avancez de " + count + " et vous êtes maintenant sur la case " + currentCase + " !\n"
					+ positionCase.open((Fighters) chosenHero);
			if(chosenHero.getLife() <= 0) {
				status = GameStatus.FINISHED;
			}
		}
	}

}