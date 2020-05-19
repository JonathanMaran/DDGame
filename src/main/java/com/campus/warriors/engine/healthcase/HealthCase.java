package com.campus.warriors.engine.healthcase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;
import com.campus.warriors.engine.Warrior;

public class HealthCase implements Case {

	int potionPoints;
	String name;


	public HealthCase(int potionPoints, String name) {
		this.potionPoints = potionPoints;
		this.name = name;

	}


	@Override
	public String open(Fighters fighter) {
		String answer = null;
		
		fighter.setLife(fighter.getLife() + this.potionPoints);
		answer = "La chance ! Vous tombez sur une case potion qui vous attribue un bonus de + " + this.potionPoints + "! \n"
				+ "Vous avez maintenant " + fighter.getLife() + " points de vie !";
		
		return answer;
	
	}
}

