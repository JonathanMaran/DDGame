package com.campus.warriors.engine.attackcase;

import com.campus.warriors.engine.Fighters;

public class SwordCase extends AttackCase {

	public SwordCase() {
		super(5, "Epée");

	}
	
	public void bonus(Fighters fighter) {
		fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusAttack);
	}
	
}