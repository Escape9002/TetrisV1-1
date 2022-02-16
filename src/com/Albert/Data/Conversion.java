package com.Albert.Data;



public class Conversion {



public static int cellToCoord(int cell) {
		
		return cell * (32); //Wandelt Rasterzelle in Koordinaten	
	}
	
	public static int coordoCell(int coord) {
		
		return coord / 32; //wandelt Koordinaten in Rasterzellen
	}
	
	
	
} 
