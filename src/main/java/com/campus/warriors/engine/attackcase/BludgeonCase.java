package com.campus.warriors.engine.attackcase;

import com.campus.warriors.engine.Fighters;

public class BludgeonCase extends AttackCase {

	public BludgeonCase() {
		super(3, "Massue");

	}
	
	public void bonus(Fighters fighter) {
		fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusAttack);
	}
	
}