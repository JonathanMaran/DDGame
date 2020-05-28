package com.campus.warriors.client.console;

import java.util.List;
import java.util.Scanner;

import com.campus.warriors.contracts.GameState;
import com.campus.warriors.contracts.GameStatus;
import com.campus.warriors.contracts.Hero;
import com.campus.warriors.contracts.Map;
import com.campus.warriors.contracts.WarriorsAPI;
import com.campus.warriors.engine.Game;
import com.campus.warriors.engine.Warriors;
import com.campus.warriors.engine.database.GameDAO;
import com.campus.warriors.engine.database.SingletonConnection;

public class ClientConsole {

	private static String MENU_COMMENCER_PARTIE = "1";
	private static String MENU_COMMENCER_PARTIE_MODE_DEBUG = "2";
	private static String MENU_QUITTER = "3";
	private static String MENU_CHARGER_PARTIE = "4"; 

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		String menuChoice = "";
		do {
			menuChoice = displayMenu(sc);
			if(menuChoice.equals(MENU_COMMENCER_PARTIE)) {
				WarriorsAPI warriors = new Warriors();
				startGame(warriors, sc);
			}else if(menuChoice.equals(MENU_COMMENCER_PARTIE_MODE_DEBUG)) {
				WarriorsAPI warriors = new Warriors(true);
				startGame(warriors, sc);
			}else if(menuChoice.equals(MENU_CHARGER_PARTIE)) {
				WarriorsAPI warriors = new Warriors();
				//faire méthode pour reprendre la partie
				resumeGame(warriors, sc);
			}
		}while(!menuChoice.equals(MENU_QUITTER));
		sc.close();
		System.out.println("A bientôt");
	}

	private static void resumeGame(WarriorsAPI warriors, Scanner sc) {

		GameDAO loadGame = new GameDAO(SingletonConnection.getInstance());

		List<Game> listLoadGame = loadGame.findAll();
		int j = 0;
		for (j = 0; j < listLoadGame.size(); j++) {
			System.out.println(String.format(
					"Partie : " + loadGame.findAll().get(j).getGameId()  + ", Nom du héro: %s, Vie actuelle: %d, Force actuelle: %d, Case actuelle: %d",
					listLoadGame.get(j).getHero().getName(), listLoadGame.get(j).getHero().getLife(), listLoadGame.get(j).getHero().getAttackLevel(), listLoadGame.get(j).getCurrentCase()));
		}

		System.out.println("Quelle partie souhaitez-vous reprendre ?");
		int id = Integer.parseInt(sc.nextLine());
		Game chosenGame = loadGame.find(id);

		while (chosenGame.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(chosenGame.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le dé"); 
			if(sc.hasNext()) {
				sc.nextLine();
				chosenGame = (Game) warriors.nextTurn(chosenGame.getGameId());

			}									
		}
		
		System.out.println(chosenGame.getLastLog());




	}

	private static void startGame(WarriorsAPI warriors, Scanner sc) {
		System.out.println();
		System.out.println("Entrez votre nom:");
		String playerName = sc.nextLine();

		System.out.println("Choisissez votre héro:");
		for(int i = 0; i < warriors.getHeroes().size(); i++) {
			Hero heroe = warriors.getHeroes().get(i);
			System.out.println(i+1 + " - " + heroe.getName());
			System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
			System.out.println("    Niveau de vie : " + heroe.getLife());
		}

		// tant que l'entier n'est pas satisfaisant
		Hero chosenHero = null;
		while(chosenHero == null) {
			try {
				// saisir un entier
				chosenHero = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);
				// pour sortir de la boucle
				// break;
			} catch (NumberFormatException e) {
				System.out.println("Entrez un nombre !");
			} catch(IndexOutOfBoundsException e2) {
				System.out.println("Entrez un nombre compris entre 1 et "+ warriors.getHeroes().size());
			} catch (Exception e3) {
				System.out.println("Erreur inconnue");
				// send email to admin as an unknown error occured.
			}

		}




		System.out.println("Choisissez votre map:");
		for(int i = 0; i < warriors.getMaps().size(); i++) {
			Map map = warriors.getMaps().get(i);
			System.out.println(i+1 + " - " + map.getName());
		}

		Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

		// s'il existe une Game sauvegardée, alors on la reprend, sinon on crée une nouvelle Game
		GameState gameState = warriors.createGame(playerName, chosenHero, choosenMap);
		String gameId = gameState.getGameId();
		while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
			System.out.println(gameState.getLastLog());
			System.out.println("\nAppuyer sur une touche pour lancer le dé"); 
			if(sc.hasNext()) {
				sc.nextLine();
				gameState = warriors.nextTurn(gameId);

			}									
		}

		System.out.println(gameState.getLastLog());
	}

	private static String displayMenu(Scanner sc) {
		System.out.println();
		System.out.println("================== Java Warriors ==================");
		System.out.println("1 - Commencer une partie");
		System.out.println("2 - Commencer une partie en mode debug");
		System.out.println("3 - Quitter");
		System.out.println("4 - Reprendre une partie sauvagardée");
		if(sc.hasNext()) {
			String choice = sc.nextLine();
			return choice;
		}		

		return "";
	}
}

