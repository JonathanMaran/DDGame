package com.campus.warriors.engine.spellcase;

import com.campus.warriors.engine.Fighters;

public class FireBallCase extends SpellCase {
	
	public FireBallCase() {
		super(7, "Boule de Feu");
	
	}
	
	public void bonus(Fighters fighter) {
		fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusSpell);
	}
}