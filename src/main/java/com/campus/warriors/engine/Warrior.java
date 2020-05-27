package com.campus.warriors.engine;

public class Warrior extends Fighters {

	
	public Warrior(String string, String string2, int int1, int int2, int int3) {
		super(string, string2, int1, int2, int3);
	}

	@Override
	public void setLife(int life) {
		//life = min(0, life);
		//life = max(life, 10);
		//super.setLife(life);
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
