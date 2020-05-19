package com.campus.warriors.engine.attackcase;

import com.campus.warriors.engine.Fighters;

public class BowCase extends AttackCase {

	public BowCase() {
		super(1, "Arc");

	}
	
	public void bonus(Fighters fighter) {
		fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusAttack);
	}
	
}