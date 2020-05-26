package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Game;

public class GameDAO extends DAO<Game>{

	public GameDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Game find(int id) {
		Game game = null;     

		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Game WHERE GameId = " + id);

			// instanciation du FightersDAO pour pouvoir avoir accès aux HeroID, life
			DAO<Fighters> fightersDao = new FightersDAO(SingletonConnection.getInstance());

			if(result.first()) {
				// je récupère la première colonne qui correspond au HeroId
				Fighters searchFighters = fightersDao.find(result.getInt("HeroId"));
				game = new Game(
						result.getString("PlayerName"),
						searchFighters,
						null,
						result.getString("GameId")
						);}          
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

	@Override
	public List<Game> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

