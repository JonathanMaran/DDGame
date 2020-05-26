package com.campus.warriors.engine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.campus.warriors.contracts.GameState;
import com.campus.warriors.contracts.Hero;
import com.campus.warriors.contracts.Map;
import com.campus.warriors.contracts.WarriorsAPI;
import com.campus.warriors.engine.database.FightersDAO;
import com.campus.warriors.engine.maps.BaseMap;
import com.campus.warriors.engine.maps.FirstMap;

public class Warriors implements WarriorsAPI {

	private boolean debugMode;
	private int gameCount;
	private java.util.Map<String, Game> startedGames;
	private FightersDAO fightersDao;
	Connection conn;

	public Warriors() {
		this(false);
	}
	
	public Warriors(boolean debugMode) {
		this.gameCount = 1;
		this.debugMode = debugMode;
		this.startedGames = new HashMap<String, Game>();
		this.fightersDao = new FightersDAO(conn);
	}
	
	public boolean isDebugMode() {
		return debugMode;
	}

	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}

	@Override
	public List<? extends Hero> getHeroes() {
		//on va chercher les infos en base de données
		
		return fightersDao.findAll();
		//return List.of(new Warrior(), new Magician());
	}

	@Override
	public List<? extends Map> getMaps() {
		// TODO Auto-generated method stub
		// Même résultat que le List.of() au dessus
		List <Map> maps = new ArrayList<Map>();
		maps.add(new FirstMap());
		return maps;
	}

	@Override
	public GameState createGame(String playerName, Hero hero, Map map) {
		if (!(map instanceof BaseMap)) {
			throw new IllegalArgumentException("The map is not supported");
		}

		String gameId = "game - " + gameCount;
		Game game = new Game(playerName, hero, (BaseMap) map, gameId);
		gameCount = gameCount + 1;
		startedGames.put(gameId, game);
		return game;
	}

	@Override
	public GameState nextTurn(String gameID) {
		Game game = startedGames.get(gameID);
		int count =0;
		//création du dé
		// si je suis en débug, je lis un fichier
		if(debugMode) {
			count = 2;
		}else {
			//, sinon comportement normal
			count = (int) (Math.random()*(6)+1);
		}

		game.moveHero(count);
		return game;

	}
}