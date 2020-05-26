package com.campus.warriors.engine.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.campus.warriors.contracts.Hero;
import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Magician;
import com.campus.warriors.engine.Warrior;




public class DatabaseManager {

	public void getHero(int id) {

		System.out.println("Méthode getHero():");
		try {
			//Création d'un objet Statement
			Statement state = SingletonConnection.getInstance().createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM Hero WHERE id = " + id);
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();

			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			}
			System.out.println("\n**********************************");

			while(result.next()){         
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() + "\t |");

				System.out.println("\n---------------------------------");

			}

			result.close();
			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<? extends Hero> getHeroes() {

		//System.out.println("Méthode getHeroes() :");

		List<Hero> heroes = new ArrayList<Hero>();

		try {
			//Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM Hero");
			



			//System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			//for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
				//System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			//}
			//System.out.println("\n**********************************");

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

	public void createHero() {

		System.out.println("Méthode createHero():");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez votre type de Fighter:");
		String guerrier = sc.nextLine();


		System.out.println("Entrez votre nom de " + guerrier + ":");
		String name = sc.nextLine();

		System.out.println("Entrez votre nom d'image:");
		String image = sc.nextLine();


		System.out.println("Entrez votre niveau de vie:");
		int niveauVie = sc.nextInt();
		sc.nextLine();

		System.out.println("Entrez votre niveau de force:");
		int niveauForce = sc.nextInt();
		sc.nextLine();


		//Création d'un objet Statement
		try {
			//Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			state.executeUpdate("INSERT INTO `Hero` (`Type`, `Nom`, `Image`, `NiveauVie`, `NiveauForce`)\n" + 
					"VALUES ('"+ guerrier + "','"+ name + "','" + image + "','" + niveauVie +"','" + niveauForce+ "')");


		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void updateHero() {

		System.out.println("Méthode updateHero():");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez l'ID du héro que vous souhaitez modifier :");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Entrez votre type de Fighter:");
		String guerrier = sc.nextLine();


		System.out.println("Entrez votre nom de " + guerrier + ":");
		String name = sc.nextLine();

		System.out.println("Entrez votre nom d'image:");
		String image = sc.nextLine();


		System.out.println("Entrez votre niveau de vie:");
		int niveauVie = sc.nextInt();
		sc.nextLine();

		System.out.println("Entrez votre niveau de force:");
		int niveauForce = sc.nextInt();
		sc.nextLine();

		//Création d'un objet Statement
		try {
			//Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			//update
			state.executeUpdate("UPDATE `Hero` SET\n" + 
					"`Type` = '" + guerrier + "',\n" + 
					"`Nom` = '" + name + "',\n" + 
					"`Image` = '" + image + "',\n" + 
					"`NiveauVie` = '" + niveauVie + "',\n" + 
					"`NiveauForce` = '" + niveauForce + "'\n" + 
					"WHERE `Id` = '" + id + "'");


		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void deleteHero() {

		System.out.println("Méthode deleteHero():");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez l'ID du héro que vous souhaitez supprimer:");
		int id = sc.nextInt();


		//Création d'un objet Statement
		try {
			//Création d'un objet Statement avec singleton
			Statement state = SingletonConnection.getInstance().createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			state.executeUpdate("DELETE FROM `Hero`\n" + 
					"WHERE `Id` = '" + id + "';");


		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}



