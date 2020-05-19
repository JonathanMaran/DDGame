package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Fighters;

public class GobelinCase extends EnemieCase {
	
	public GobelinCase() {
		super(6, 1, "Gobelin");

	}
	
	public void attack(Fighters fighter) {
		fighter.setLife(fighter.getLife() - this.attackPoints);
	}
}