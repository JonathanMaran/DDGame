package com.campus.warriors.engine.healthcase;

import com.campus.warriors.engine.Fighters;

public class LittlePotionCase extends HealthCase {

	public LittlePotionCase() {
		super(1, "Potion de vie mineure");
		
	}
	
	public void potion(Fighters fighter) {
		fighter.setLife(fighter.getLife() + this.potionPoints);
	}
}