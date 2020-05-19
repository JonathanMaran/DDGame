package com.campus.warriors.engine.enemiecase;

import com.campus.warriors.engine.Case;
import com.campus.warriors.engine.Fighters;

public class EmptyCase implements Case {

	@Override
	public String open(Fighters fighter) {
		String answer = null;
		
		answer = "CASE VIDE ! \n"
				+ "Vous êtes sur une case vide, l'occasion idéale de se reposer et reprendre des forces !";
		
		return answer;
	}
	
}