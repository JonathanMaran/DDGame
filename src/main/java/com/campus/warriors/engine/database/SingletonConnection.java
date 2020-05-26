package com.campus.warriors.engine.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	  //URL de connexion
	  private String url = "jdbc:mysql://adminer.local/DDGame?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	  //Nom du user
	  private String user = "jonathanmrn";
	  //Mot de passe de l'utilisateur
	  private String passwd = "lecampusnumerique";
	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur privé, pour interdire l'instanciation d'une classe
	  private SingletonConnection(){
	    try {
	      connect = DriverManager.getConnection(url, user, passwd);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	   
	  //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	   public static Connection getInstance(){
	    if(connect == null){
	      new SingletonConnection();
	      //System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
	    }
	      else {
	    	 //System.out.println("CONNEXION SQL EXISTANTE ! ");
	      }
	    return connect;   
	  }   
}
