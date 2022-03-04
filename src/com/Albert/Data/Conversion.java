package com.Albert.Data;

/*
 * Coversionklasse mit dem Methoden zum konvertieren zwischen den Zellen des 2dimensionalen Map Array und den Koordinaten des Fensters
 * 
 */

public class Conversion {

	public static int cellToCoord(int cell) { // Zelle zu Koordinaten wandeln

		return cell * (32); // Wandelt Rasterzelle in Koordinaten
	}

	public static int coordoCell(int coord) {// Koordinaten zu Zellen wandeln

		return coord / 32; // wandelt Koordinaten in Rasterzellen
	}

}
