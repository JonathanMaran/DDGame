package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Magician;
import com.campus.warriors.engine.Warrior;


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
	
	@Override
	public List<Fighters> findAll() {
		List<Fighters> heroes = new ArrayList<Fighters>();

		try {
			//Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM Hero");
			while(result.next()){  
				Fighters fighter = null;
				
				if(result.getString("Type").equalsIgnoreCase("guerrier")) {
					fighter = new Warrior();
					
				} else {
					fighter = new Magician();
				}
				//for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
					//System.out.print("\t" + result.getObject(i).toString() + "\t |");
				//}
				//System.out.println("\n---------------------------------");
				fighter.setName(result.getString("Nom"));
				fighter.setLife(result.getInt("NiveauVie"));
				fighter.setAttackLevel(result.getInt("NiveauForce"));
				heroes.add(fighter);
			}

			result.close();
			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return heroes; 
	}

}


