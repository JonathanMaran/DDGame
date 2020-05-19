package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Fighters;

public class WizardCase extends EnemieCase {

	public WizardCase() {
		super(9, 2, "Sorcier");

	}

	public void attack(Fighters fighter) {
		fighter.setLife(fighter.getLife() - this.attackPoints);
	}

}