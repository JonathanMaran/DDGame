package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Game;
import com.campus.warriors.engine.maps.FirstMap;

public class GameDAO extends DAO<Game> {

	public GameDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Game obj) {
		try {
			// Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			// update
			state.executeUpdate(
					"INSERT INTO `Game` (`PlayerName`, `HeroId`, `GameId`, `CurrentCase`, `HeroLife`, `HeroAttackLevel`)"
							+ "VALUES ('" + obj.getPlayerName() + "', '" + obj.getHero().getId() + "', '"
							+ obj.getGameId() + "' ,'" + obj.getCurrentCase() + "', '" + obj.getHero().getLife()
							+ "' ,'" + obj.getHero().getAttackLevel() + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean delete(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Game obj) {

		try {
			// Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			// update

			state.executeUpdate(String.format(
					"UPDATE `Game` SET `CurrentCase` = '%d', `HeroLife` = '%d', `HeroAttackLevel` = '%d' WHERE `GameId` = '%s'",
					obj.getCurrentCase(), obj.getHero().getLife(), obj.getHero().getAttackLevel(), obj.getGameId()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Game find(int id) {
		Game game = null;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Game WHERE GameId = " + id);

			// instanciation du FightersDAO pour pouvoir avoir accès aux HeroID, life
			DAO<Fighters> fightersDao = new FightersDAO(SingletonConnection.getInstance());

			if (result.first()) {
				// je récupère la première colonne qui correspond au HeroId
				Fighters searchFighters = fightersDao.find(result.getInt("HeroId"));
				game = new Game(result.getString("PlayerName"), searchFighters, null, result.getString("GameId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

	@Override
	public List<Game> findAll() {
		List<Game> game = new ArrayList<Game>();

		try {
			// Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			// L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM Game");

			// instanciation du FightersDAO pour pouvoir avoir accès aux HeroID, life
			DAO<Fighters> fightersDao = new FightersDAO(SingletonConnection.getInstance());

			while (result.next()) {
				Game tmpGame = new Game(result.getString("PlayerName"), fightersDao.find(result.getInt("HeroId")), null,
						result.getString("GameId"));
				
				tmpGame.setChosenMap(new FirstMap());
				
				game.add(tmpGame);

			}

			result.close();
			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}

}
