package com.Albert.Userinterface;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;


public class DrawInterface extends JLabel {

	protected void paintComponent(Graphics g) { //Kein Rückgabewert Methode ist durch Protected auch in vererbten Klassen verwendbar sonst wäre sie nur im Package verwendbar
		
		super.paintComponent(g); //Übergabe des  Graphics Objektes g
		
		g.setColor(Color.LIGHT_GRAY); //Farbe HellGrau
		
		
		for (int x=0; x<4; x++) { //Zeichnen des Feldes für den komenden Blockes 4x4
			for(int y=0; y<4; y++) { 
				g.drawRect(x*32+32, y*32, 32, 32); 
				
			}
			
		}
	   g.setColor(Color.BLACK);
	   g.drawRect(32, 0, 4*32, 4*32); //Zeichnen eines Rechtecks außernrum
		
		repaint(); //"neuzeichnen/akktualisieren"
		
		


	}
	
	
	
	
	
}