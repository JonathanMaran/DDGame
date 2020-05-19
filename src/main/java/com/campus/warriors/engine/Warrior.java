package com.campus.warriors.engine;

public class Warrior extends Fighters {

	public Warrior() {
		super("Johnzy", "image", 5, 5);

	}

	@Override
	public void setLife(int life) {
		if(life > 10) {
			this.life = 10;
		}else if (life < 0) {
			this.life = 0;
		}else {
			this.life = life;
		}
	}

	@Override
	public void setAttackLevel(int attackLevel) {
		if(attackLevel > 10) {
			this.attackLevel = 10;
		}else if (attackLevel < 0) {
			this.attackLevel = 0;
		}else {
			this.attackLevel = attackLevel;
		}
	}
}
