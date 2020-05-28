package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			//Statement state = SingletonConnection.getInstance().createStatement();
			PreparedStatement pState = this.connect.prepareStatement("INSERT INTO `Game` (`PlayerName`, `HeroId`, `CurrentCase`, `HeroLife`, `HeroAttackLevel`)"
					+ "VALUES ('" + obj.getPlayerName() + "', '" + obj.getHero().getId() + "', '"
					+ obj.getCurrentCase() + "', '" + obj.getHero().getLife()
					+ "' ,'" + obj.getHero().getAttackLevel() + "')", Statement.RETURN_GENERATED_KEYS);

			pState.executeUpdate();

			ResultSet result = pState.getGeneratedKeys();

			if(result.next()) {
				obj.setId(Integer.toString(result.getInt(1)));
			}

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
					"UPDATE `Game` SET `CurrentCase` = '%d', `HeroLife` = '%d', `HeroAttackLevel` = '%d' WHERE `Id` = '%s'",
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
					.executeQuery("SELECT * FROM Game WHERE Id = " + id);

			// instanciation du FightersDAO pour pouvoir avoir accès aux HeroID, life
			DAO<Fighters> fightersDao = new FightersDAO(SingletonConnection.getInstance());

			if (result.first()) {
				// je récupère la première colonne qui correspond au HeroId
				Fighters searchFighters = fightersDao.find(result.getInt("HeroId"));
				game = new Game(result.getString("PlayerName"), searchFighters, null);
				game.setId(result.getString("Id"));
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
				Fighters findFighter = fightersDao.find(result.getInt("HeroId"));
				findFighter.setLife(result.getInt("HeroLife"));
				findFighter.setAttackLevel(result.getInt("HeroAttackLevel"));
				
				Game tmpGame = new Game(result.getString("PlayerName"), findFighter , null);
				tmpGame.setId(result.getString("Id"));
				tmpGame.setCurrentCase(result.getInt("CurrentCase"));
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
