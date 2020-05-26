package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.campus.warriors.engine.Fighters;


public class FightersDAO extends DAO<Fighters>{



	public FightersDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Fighters obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Fighters obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Fighters obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Fighters find(int id) {
		Fighters fighters = null;     

		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Hero WHERE id = " + id);
			if(result.first())
				fighters = new Fighters(
						result.getString("Nom"),
						result.getString("Image"),
						result.getInt("NiveauVie"),
						result.getInt("NiveauForce")
						);          
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fighters;

	}

}


