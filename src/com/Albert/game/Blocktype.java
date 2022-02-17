package com.Albert.game;

import java.util.concurrent.ThreadLocalRandom;

public enum Blocktype {
	I,O,T,L,J,Z,S; // Type kann die einelnen Bloecke waehlen
	
	public static Blocktype random() { 		//Funktion zuffaeliger Block
		
		return values()[ThreadLocalRandom.current().nextInt(0,values().length)];

	}
}
