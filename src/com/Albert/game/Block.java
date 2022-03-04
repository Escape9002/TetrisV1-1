package com.Albert.game;
/*Imports */
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Klasse der Blöcke des Tetrisspiels
 * Hier sind die getter und setter der Blöcke, 
 * werden die Variablen des Blockes auf den neu zufällig-
 * generierten gesetzt.
 * 
 */



public class Block {     

	Blocktype type; // Variable von Blocktype mit dem Namen type
	
	int x, y, size, rotation =0;  // initialisieren der x,y,size und rotation Variable
	int[][][] bounds; // deklarieren der bound Variable (3Dimensionales Array)
	
	Color color; //deklarieren der Color Variable
	
	boolean movable = true; //initialisieren des movable 
	     
	
	public Block() { //Konstruktor
		
		type = Blocktype.random(); // Methode zum erzugen eines Zufaelliger Blocktyps
		
		switch(type) { //Anpassen der Variable Size auf den Blocktyp
		case I: // I Block (lange vierer Reihe)
			size=4; // 4*4
			break;
		case O: //O Block (Viereck)
		   size=2; //2*2
		   break;
		default: //alle anderen Blöcke
			size=3;//3*3
			break;
		}
		
		switch(type) { // Anpassen der Farben(Variable) auf den Blocktyp 
		case I:
			color = Color.CYAN;  // I Block =Cyan
			break;
		case O:
			color = Color.YELLOW; // O Block = Yellow
			break;
		case T:
			color = Color.MAGENTA; // T Block = Magenta
			break;
		case L:
			color= Color.ORANGE; // L Block = Orange
			break;
		case J:
			color = Color.BLUE; // J Block = Blue
			break;
		case Z: 
			color = Color.red; // Z Block = Red
			break;
		case S:
			color =Color.GREEN; // S Block = Green
			break;
		}
	
		x = 4; //In der Mitte spawn (Startwert)
		y = -2;	//oberhalbspawn (Startwert)
		
		try {                                                 //3D Array Bounds auf die Blockbuilderwerte setzten ( aus den TXT) Methode unterhalb
			bounds =blockBuilder(type);          
			System.out.println("Blockbuilder runs");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void rotate() { //Rotations Methode zum Veränden des Rotationswert auf Tastendruck
		rotation ++;
		if(rotation ==4) { // Nur 4 Rotationstufen, daher wird beim Wert 4 wieder auf null setzten
			rotation =0;
		}
		
	}
	
	public int[][][] blockBuilder(Blocktype type) throws FileNotFoundException{ //Methode die Blöcke aus den Txt Dateien in das Boundsarray zu schreiben

		int[][][] bounds; // Bounds Variable

		switch(type) { // Länge der einzelnen Arrays, je nach Größe des Blockes

		case I:
			bounds =new int[4][4][4]; // Lange der Array = 4, da der Block I eine maximale Länge von 4 hat
			break;

		case O:
			bounds= new int[4][2][2]; // Länge der Arrays =2, da der Block O ein 2*2 Block ist
			break;

		default:
			bounds= new int[4][3][3]; // defaul Länge der Arrays, da alle anderen Blöcke in ein 3*2 Muster passen.
			break;
		}

		File file = new File("rsc/blocks/" + type + ".txt");      // file Pfad auf den Blocktyp anpassen und anwenden
		System.out.println("rsc/blocks/" + type + ".txt"); //debug
		Scanner sc = new Scanner(file); // Mit dem Scanner den file auslesen, Dateipfad oberhalb

		/*
		 * (unterhalb) Die Werte aus dem Scanner werden in das 3 dimensionale Array eingetragen
		 */
		for (int variant = 0; variant < 4; variant++) { 
			for (int i = 0; i < bounds[0].length; i++) {

				if (sc.hasNext()) {
					String[] srow = sc.next().split("");
					int[] row = new int[bounds[0].length];

					for (int j = 0; j < row.length; j++) {
						row[j] = Integer.valueOf(srow[j]);
						bounds[variant][j][i] = row[j];

					}
				}
			}
		}

		return bounds; // die Bounds werden zurückgegeben, damit die bounds Variable des Objekts auf die Werte gesetzt werden kann

	}

	/*
	 * Teils autogenerierte, teils selbstgeschriebene getter/setter
	 * 
	 */
	
	public Color getColor() { 
		// TODO Auto-generated method stub
		return color; // gibt Color zurück
	}


	public Blocktype getType() {
		return type; // gibt Blocktyp zurück
	}

	public void setType(Blocktype type) {
		this.type = type; // verändert den Blöcktyp
	}

	public int getX() {
		return x; // gibt den x Wert zurück
	}

	public void setX(int x) {
		this.x = x; // Setzt den x Wert neu
	}

	public int getY() {
		return y; // gibt den y Wert zurück
	}

	public void setY(int y) {
		this.y = y; // Setzt den y Wert neu
	}

	public int getSize() {
		return size; // gibt die Größe zurück
	}

	public void setSize(int size) {
		this.size = size; // Setzt die Größe neu
	}

	public int getRotation() {
		return rotation; // Gibt die Rotation zurück
	}

	public void setRotation(int rotation) {
		this.rotation = rotation; // Setzt die Rotation neu
	}

	public int[][][] getBounds() {
		return bounds; // gibt die Bounds zurück
	}

	public void setBounds(int[][][] bounds) {
		this.bounds = bounds; // Setzt die Bounds neu
	}

	public boolean isMovable() {
		return movable; // gibt den Wert des movable zurück
	}

	public void setMovable(boolean movable) {
		this.movable = movable; //setzt den Wert des movable neu
	}

	public void setColor(Color color) {
		this.color = color; // Setzt die Farbe neu
	}

	public int getTypeValue() {
		// Gibt den Wert (value) für das Maparray passend zu denm Blocktyp zurück

		switch(type) {
		
		case I: return 1;
		case O: return 2;
		case T: return 3;
		case L: return 4;
		case J: return 5;
		case Z: return 6;
		case S: return 7;
		}
		
		return  0;
		}
		
		
		
	}

