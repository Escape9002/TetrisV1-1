package com.Albert.Data;

import com.Albert.Userinterface.Gui;

public class Conversion {
Gui d;
	


public static int cellToCoord(int cell) {
		
		return cell * (Gui.width/Gui.anzahlbreite);
	}
	
	public static int coordoCell(int coord) {
		
		return coord / (Gui.width/Gui.anzahlbreite);
	}
	
	
	
} 
