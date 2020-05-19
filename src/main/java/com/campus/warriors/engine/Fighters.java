package com.campus.warriors.engine;

import com.campus.warriors.contracts.Hero;
import com.campus.warriors.engine.enemiecase.EnemieCase;

public class Fighters implements Hero {

	protected String name;
	protected String image;
	protected int life;
	protected int attackLevel;
	
	public Fighters(String name, String image, int life, int attackLevel) {
	this.name = name;
	this.image = image;
	this.life = life;
	this.attackLevel = attackLevel;

	}
	
	public void attack(EnemieCase enemie) {
		enemie.setHealthPoints(enemie.getHealthPoints()- this.attackLevel);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return life;
	}

	@Override
	public int getAttackLevel() {
		// TODO Auto-generated method stub
		return attackLevel;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void setAttackLevel(int attackLevel) {
		this.attackLevel = attackLevel;
	}


}