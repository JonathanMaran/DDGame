package com.campus.warriors.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.campus.warriors.contracts.GameState;
import com.campus.warriors.contracts.Hero;
import com.campus.warriors.contracts.Map;
import com.campus.warriors.contracts.WarriorsAPI;
import com.campus.warriors.engine.database.FightersDAO;
import com.campus.warriors.engine.database.GameDAO;
import com.campus.warriors.engine.database.SingletonConnection;
import com.campus.warriors.engine.maps.BaseMap;
import com.campus.warriors.engine.maps.FirstMap;

public class Warriors implements WarriorsAPI {

	private boolean debugMode;
	private int gameCount;
	private java.util.Map<String, Game> startedGames;
	private FightersDAO fightersDao;

	public Warriors() {
		this(false);
	}
	
	public Warriors(boolean debugMode) {
		this.gameCount = 1;
		this.debugMode = debugMode;
		List<Game> tmptGameList = new GameDAO(SingletonConnection.getInstance()).findAll();
		this.startedGames = new HashMap<String, Game>();
		for(int i = 0; i < tmptGameList.size(); i++) {
			this.startedGames.put(tmptGameList.get(i).getGameId(), tmptGameList.get(i));
		}
		this.fightersDao = new FightersDAO(SingletonConnection.getInstance());
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

		Game game = new Game(playerName, hero, (BaseMap) map);
		
		GameDAO gameDao = new GameDAO(SingletonConnection.getInstance());
		gameDao.create(game);
		
		gameCount = gameCount + 1;
		startedGames.put(game.getGameId(), game);
		// CREATE GAMEDAO pour faire le lien avec BDD lors de la création de la partie
		
		
		
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
		GameDAO gameDao = new GameDAO(SingletonConnection.getInstance());
		gameDao.update(game);
		return game;

	}
}