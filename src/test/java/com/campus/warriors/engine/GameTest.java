package com.campus.warriors.engine;

import com.campus.warriors.engine.maps.FirstMap;

public class GameTest {
	public void userShouldLeaveBoard() {
		Game g = new Game("Jo", new Warrior(), new FirstMap(), "1");
		g.setCurrentCase(60);
		g.moveHero(4);
	}
		public void userShouldDie() {

		}

		public void userShouldFightAndWin() {

		}

	}
