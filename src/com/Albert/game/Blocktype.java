package com.Albert.game;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Enum der Verschiedenen Blocktypen mit ihren Buchstaben als Bezeichnung
 * 
 
 */



public enum Blocktype {
	I,O,T,L,J,Z,S; // Type kann die einelnen Bloecke waehlen
	
	public static Blocktype random() { // Methode zum erzeugen eines zufälligen Blocktypes
		
		return values()[ThreadLocalRandom.current().nextInt(0,values().length)];

	}
}
