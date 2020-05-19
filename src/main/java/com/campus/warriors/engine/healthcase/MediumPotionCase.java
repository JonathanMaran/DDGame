package com.campus.warriors.engine.healthcase;

import com.campus.warriors.engine.Fighters;

public class MediumPotionCase extends HealthCase {

	public MediumPotionCase() {
		super(2, "Potion de vie standard");
		
	}
	
	public void potion(Fighters fighter) {
		fighter.setLife(fighter.getLife() + this.potionPoints);
	}
	
}