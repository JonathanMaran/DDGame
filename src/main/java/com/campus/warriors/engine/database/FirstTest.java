package com.campus.warriors.engine.database;

import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Game;

public class FirstTest {
	 public static void main(String[] args) {
		    //Testons les fighters
		    DAO<Fighters> fightersDao = new FightersDAO(SingletonConnection.getInstance());
		    for(int i = 1; i < 3; i++){
		     Fighters fighters = fightersDao.find(i);
		      System.out.println("Fighters:" + fighters.getName() + " - " + fighters.getImage() + " - " + fighters.getLife() + " - " + fighters.getAttackLevel());
		    }
		      
		    System.out.println("\n********************************\n");
		    
		    //Testons les fighters
		    DAO<Game> gameDao = new GameDAO(SingletonConnection.getInstance());
		    for(int i = 1; i < 3; i++){
		    Game game = gameDao.find(i);
		      System.out.println("Game:" + game.getHero().getAttackLevel()+ " - " + game.getGameId() + " - " + game.getPlayerName() + " - " + game.getGameStatus() );
		    }
		      
		    System.out.println("\n********************************\n");
		      
		  }
}
