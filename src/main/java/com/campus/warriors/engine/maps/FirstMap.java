package com.campus.warriors.engine.maps;

import java.util.ArrayList;
import java.util.List;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.attackcase.BludgeonCase;
import com.campus.warriors.engine.attackcase.BowCase;
import com.campus.warriors.engine.attackcase.SwordCase;
import com.campus.warriors.engine.enemiecase.DragonCase;
import com.campus.warriors.engine.enemiecase.EmptyCase;
import com.campus.warriors.engine.enemiecase.GobelinCase;
import com.campus.warriors.engine.enemiecase.WizardCase;
import com.campus.warriors.engine.healthcase.GreatPotionCase;
import com.campus.warriors.engine.healthcase.LittlePotionCase;
import com.campus.warriors.engine.healthcase.MediumPotionCase;
import com.campus.warriors.engine.spellcase.FireBallCase;
import com.campus.warriors.engine.spellcase.LightningCase;

public class FirstMap extends BaseMap {
	
	ArrayList<Case> theCase;
	
	public FirstMap() {
	theCase = new ArrayList<Case>();
	// case 1 (index 0)
	theCase.add(new LightningCase());
	theCase.add(new BowCase());	
	theCase.add(new GobelinCase());
	theCase.add(new LightningCase());
	//case 5 (index 4)
	theCase.add(new BludgeonCase());
	theCase.add(new GobelinCase());
	theCase.add(new LittlePotionCase());
	theCase.add(new LightningCase());
	theCase.add(new GobelinCase());
	//case 10 (index 9)
	theCase.add(new WizardCase());
	theCase.add(new BowCase());
	theCase.add(new GobelinCase());
	theCase.add(new LittlePotionCase());
	theCase.add(new BowCase());
	//case 15 (index 14)
	theCase.add(new GobelinCase());
	theCase.add(new EmptyCase());
	theCase.add(new LightningCase());
	theCase.add(new GobelinCase());
	theCase.add(new BowCase());
	//case 20 (index 19)
	theCase.add(new WizardCase());
	theCase.add(new GobelinCase());
	theCase.add(new BludgeonCase());
	theCase.add(new LightningCase());
	theCase.add(new GobelinCase());
	//case 25 (index 24)
	theCase.add(new WizardCase());
	theCase.add(new BowCase());
	theCase.add(new GobelinCase());
	theCase.add(new LittlePotionCase());
	theCase.add(new LittlePotionCase());
	//case 30 (index 29)
	theCase.add(new GobelinCase());
	theCase.add(new MediumPotionCase());
	theCase.add(new WizardCase());
	theCase.add(new LittlePotionCase());
	theCase.add(new EmptyCase());
	//case 35 (index 34)
	theCase.add(new WizardCase());
	theCase.add(new WizardCase());
	theCase.add(new WizardCase());
	theCase.add(new BludgeonCase());
	theCase.add(new MediumPotionCase());
	//case 40 (index 39)
	theCase.add(new WizardCase());
	theCase.add(new GreatPotionCase());
	theCase.add(new SwordCase());
	theCase.add(new MediumPotionCase());
	theCase.add(new WizardCase());
	//case 45 (index 44)
	theCase.add(new DragonCase());
	theCase.add(new EmptyCase());
	theCase.add(new WizardCase());
	theCase.add(new FireBallCase());
	theCase.add(new FireBallCase());
	//case 50 (index 49)
	theCase.add(new EmptyCase());
	theCase.add(new EmptyCase());
	theCase.add(new DragonCase());
	theCase.add(new SwordCase());
	theCase.add(new EmptyCase());
	//case 55 (index 54)
	theCase.add(new EmptyCase());
	theCase.add(new DragonCase());
	theCase.add(new EmptyCase());
	theCase.add(new EmptyCase());
	theCase.add(new EmptyCase());
	//case 60 (index 59)
	theCase.add(new EmptyCase());
	theCase.add(new EmptyCase());
	theCase.add(new DragonCase());
	theCase.add(new EmptyCase());
	theCase.add(new EmptyCase());
	}
	
	@Override
	public String getName() {
		
		return "Fighting area 1";
	}

	@Override
	public int getNumberOfCase() {
	
		return 64;
	}

	@Override
	public List<Case> getListCase() {
		
		return theCase;
	}
	
}