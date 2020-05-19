package com.campus.warriors.engine.spellcase;

import com.campus.warriors.engine.Fighters;

public class LightningCase extends SpellCase {

	public LightningCase() {
		super(2, "Eclair");

	}
	
	public void bonus(Fighters fighter) {
		fighter.setAttackLevel(fighter.getAttackLevel() + this.bonusSpell);
	}

}