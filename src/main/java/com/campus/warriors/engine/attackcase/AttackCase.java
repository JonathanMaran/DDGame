package com.campus.warriors.engine.attackcase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Warrior;

public class AttackCase implements Case {

	int bonusAttack;
	String name;

	public AttackCase(int bonusAttack, String name) {
		this.bonusAttack = bonusAttack;
		this.name = name;
	}

	@Override
	public String open(Fighters fighter) {
		String answer = null;

		if(fighter instanceof Warrior) {


			if(fighter.getAttackLevel() < 6) {
				fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusAttack) ;
				answer = "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusAttack + " et celui-ci s'élève maintenant à " + fighter.getAttackLevel();
				return answer;

			} else if(this.name == "Massue" && fighter.getAttackLevel() < 8) {
				fighter.setAttackLevel(5 + this.bonusAttack);
				answer = "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusAttack +" et celui-ci s'élève maintenant à " + fighter.getAttackLevel();
				return answer;

			} else if(this.name == "Epée" && fighter.getAttackLevel() < 10) {
				fighter.setAttackLevel(5 + this.bonusAttack);
				answer = "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusAttack +" et celui-ci s'élève maintenant à " + fighter.getAttackLevel();
				return answer;

			} else {
				answer = "Vous êtes sur une case bonus mais malheureusement, le bonus que vous avez actuellement est meilleur (ou égal) à celui que vous venez de découvrir... ";
				return answer;
			}


		}else {
			answer = "Vous êtes un Magicien, du coup cette case n'a pas d'effet sur vous ;) !";
		}
		return answer;
		

	}
}

