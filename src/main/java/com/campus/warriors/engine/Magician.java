package com.campus.warriors.engine;

public class Magician extends Fighters {

	public Magician() {
		super("Kogmow", "image2", 3, 8);
	}
	
	@Override
	public void setLife(int life) {
		if(life > 6) {
			this.life = 6;
		}else if (life < 0) {
			this.life = 0;
		}else {
			this.life = life;
		}
	}
	
	@Override
	public void setAttackLevel(int attackLevel) {
		if(attackLevel > 15) {
			this.attackLevel = 15;
		}else if (attackLevel < 0) {
			this.attackLevel = 0;
		}else {
			this.attackLevel = attackLevel;
		}
	}
}