package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;

public class EmptyCase implements Case {

	@Override
	public String open(Fighters fighter) {
		System.out.println("Case vide");
		return null;
	}
	
}