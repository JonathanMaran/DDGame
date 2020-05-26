package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;

public class EnemieCase implements Case {

	int healthPoints;
	int attackPoints;
	String name;


	public EnemieCase(int healthPoints, int attackPoints, String name) {
		this.healthPoints = healthPoints;
		this.attackPoints = attackPoints;
		this.name = name;

	}
	@Override
	public String open(Fighters fighter) {
		String answer = null;
		// this représente l'objet en question
		fighter.attack(this);
		if(this.getHealthPoints() <= 0) {
			answer ="CASE ENNEMI : " + this.name + "! \n"
					+ "Vous attaquez en premier et vous faites perdre " + fighter.getAttackLevel() + " points de vie à votre adversaire ! \n"
					+ "Waouh, vous avez tué le " + this.name + "!";
			return answer;
		}else {
			// FAIRE LA SUITE DE L'ANSWER SUIVANT LES POSSIBILITES
			this.attack(fighter);
			if(fighter.getLife() <= 0) {
				answer = "CASE ENNEMI : " + this.name + "! \n"
						+ "Vous attaquez en premier et vous faites perdre " + fighter.getAttackLevel() + " points de vie à votre adversaire ! \n"
						+ "Le " + this.name + " riposte avec une attaque qui vous fait perdre " + this.getAttackPoints() + " points de vie ! \n"
						+ "Vous êtes mort ! Le " + this.name + " vous a tué...\n"
						+ "Le jeu est terminé, vous avez PERDU !";

				return answer;

			}else {
				answer = "CASE ENNEMI : " + this.name + "! \n"
						+ "Vous attaquez en premier et vous faites perdre " + fighter.getAttackLevel() + " points de vie à votre adversaire ! \n"
						+ "Le " + this.name + " riposte avec une attaque qui vous fait perdre " + this.getAttackPoints() + " points de vie ! \n"
						+ "Il vous reste donc " + fighter.getLife() + " points de vie à la fin de ce combat !";
				return answer;
			}

		}
	}

	public void attack(Fighters fighter) {
		fighter.setLife(fighter.getLife() - this.attackPoints);
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		if (healthPoints < 0) {
			this.healthPoints = 0;
		}else {
			this.healthPoints = healthPoints;
		}
	}

	public int getAttackPoints() {
		return attackPoints;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}


}