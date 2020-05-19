package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.contracts.GameStatus;
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
			answer = "Waouh, vous avez tué le " + this.name + "!";
			return answer;
		}else {
			// FAIRE LA SUITE DE L'ANSWER SUIVANT LES POSSIBILITES
			this.attack(fighter);
			if(fighter.getLife() <= 0) {
				answer = "Vous êtes mort ! Le " + this.name + " vous a tué...";
				return answer;

			}else {
				answer = "Le " + this.name + " vous a frappé avec une force de " + this.getAttackPoints() + "!, il vous reste " + fighter.getLife() + " points de vie !";
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