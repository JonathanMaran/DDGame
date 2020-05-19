package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Fighters;

public class DragonCase extends EnemieCase {
	
	public DragonCase() {
		super(15, 4, "Dragon");

	}
	
	public void attack(Fighters fighter) {
		fighter.setLife(fighter.getLife() - this.attackPoints);
	}
	

}