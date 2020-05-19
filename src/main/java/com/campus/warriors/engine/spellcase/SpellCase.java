package com.campus.warriors.engine.spellcase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Magician;

public class SpellCase implements Case {

	int bonusSpell;
	String name;

	public SpellCase(int bonusSpell, String name) {
		this.bonusSpell = bonusSpell;
		this.name = name;
	}

	@Override
	public String open(Fighters fighter) {
		String answer = null;

		if(fighter instanceof Magician) {


			if(fighter.getAttackLevel() < 9) {
				fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusSpell) ;
				answer ="CASE BONUS : " + this.name + "! \n" 
						+ "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusSpell + " et celui-ci s'élève maintenant à " + fighter.getAttackLevel() + " !";
				return answer;

			} else if(this.name == "Eclair" && fighter.getAttackLevel() < 10) {
				fighter.setAttackLevel(8 + this.bonusSpell);
				answer = "CASE BONUS : " + this.name + "! \n" 
						+ "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusSpell +" et celui-ci s'élève maintenant à " + fighter.getAttackLevel()+ " !";
				return answer;

			} else if(this.name == "Boule de Feu" && fighter.getAttackLevel() < 15) {
				fighter.setAttackLevel(8 + this.bonusSpell);
				answer = "CASE BONUS : " + this.name + "! \n"  
						+ "Vous êtes sur une case bonus ! Vous gagnez une nouvelle arme : " + this.name + " ! \n"
						+ "Cette dernière augmente votre bonus d'attaque de " + this.bonusSpell +" et celui-ci s'élève maintenant à " + fighter.getAttackLevel()+ " !";
				return answer;

			} else {
				answer ="CASE BONUS : " + this.name + "! \n"  
						+"Vous êtes sur une case bonus mais malheureusement, le bonus que vous avez actuellement est meilleur (ou égal) à celui que vous venez de découvrir...";
				return answer;
			}


		}else {
			answer ="CASE BONUS POUR LES MAGICIENS ! \n"
					+ "Vous êtes un Guerrier ! \n"
					+ "Par conséquent, cette case n'a aucun effet sur vous ;) !";
		}
		return answer;


	}

}