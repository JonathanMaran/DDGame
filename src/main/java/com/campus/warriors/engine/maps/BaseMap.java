package com.campus.warriors.engine.maps;

import java.util.List;

import com.campus.warriors.contracts.Map;
import com.campus.warriors.engine.Case;

public abstract class BaseMap implements Map {

	public abstract List<Case> getListCase();
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfCase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}