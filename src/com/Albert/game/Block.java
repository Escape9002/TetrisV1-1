package com.Albert.game;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.Albert.Userinterface.Gui;


public class Block {     
Gui b;
	Blocktype type; // Variable von Blocktype mit dem Namen type
	
	int x ; int y; int size; int rotation =0;
	int[][][] bounds;
	
	Color color;
	boolean movable = true; 
	
	public Block() { //Konstruktor
		
		type = Blocktype.random(); //Zufälliger Block
		switch(type) { 
		case I:
			size=4;
			break;
		case O:
		   size=2;
		   break;
		default:
			size=3;
			break;
		}
		
		switch(type) {
		case I:
			color = Color.CYAN;
			break;
		case O:
			color = Color.YELLOW;
			break;
		case T:
			color = Color.MAGENTA;
			break;
		case L:
			color= Color.ORANGE;
			break;
		case J:
			color = Color.BLUE;
			break;
		case Z: 
			color = Color.red;
			break;
		case S:
			color =Color.GREEN;
			break;
		}
	
		x = Gui.width/2; //In der Mitte spawn
		y = -2;	//oberhalbspawn
		
		try {                                                 //3D Array ist das aus der Blockbuilder Funktion
			bounds =blockBuilder(type);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void rotate() { //rotation VAriable für rotate Methode erhöhen
		rotation ++;
		if(rotation ==4) {
			rotation =0;
		}
		
	}
	
	public int[][][] blockBuilder(Blocktype type) throws FileNotFoundException{ //Schreibt die Blöcke in ein 3DArray
		
		int[][][] bound;
		
		switch(type) {
		
		case I:
			bounds =new int[4][4][4]; //I und O sonder, da andere Größe
			break;
		
		case O:
			bounds= new int[4][2][2];
			break;
			
		default:
			bounds= new int[4][3][3];
			break;
		}
		
		File file = new File("rsc/blocks/"+type+".txt");
		Scanner sc = new Scanner(file);
		
		for(int variant =0; variant <4; variant++) {
			for(int i =0; i<bounds[0].length;i++) {
				if(sc.hasNext()) {
					
					String[] srow =sc.next().split("");
					int[] row =new int[bounds[0].length];
					
					for(int j=0; j<row.length; j++) {
						
						row[j]= Integer.valueOf(srow[j]);
						bounds[variant][j][i] =row[j];
					}
				}
				
				
				
			}			
		}
		
		
		
		return bounds;
	}
	
	
	
	
	
	
	
}
