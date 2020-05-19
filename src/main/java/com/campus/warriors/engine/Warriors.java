package com.campus.warriors.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.campus.warriors.contracts.GameState;
import com.campus.warriors.contracts.Hero;
import com.campus.warriors.contracts.Map;
import com.campus.warriors.contracts.WarriorsAPI;
import com.campus.warriors.engine.maps.BaseMap;
import com.campus.warriors.engine.maps.FirstMap;

public class Warriors implements WarriorsAPI {

	int gameCount = 1;
	java.util.Map<String, Game> startedGames = new HashMap<String, Game>();

	@Override
	public List<? extends Hero> getHeroes() {
		// TODO Auto-generated method stub
		return List.of(new Warrior(), new Magician());
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
		//création du dé
		int count = (int) (Math.random()*(6)+1);
		game.moveHero(count);
		return game;
	
	}
}