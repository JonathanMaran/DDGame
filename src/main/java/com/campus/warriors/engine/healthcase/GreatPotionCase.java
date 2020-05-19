package com.campus.warriors.engine.healthcase;

import com.campus.warriors.engine.Fighters;

public class GreatPotionCase extends HealthCase {

	public GreatPotionCase() {
		super(5, "Grande potion de vie");
		
	}
	
	public void potion(Fighters fighter) {
		fighter.setLife(fighter.getLife() + this.potionPoints);
	}
	
}