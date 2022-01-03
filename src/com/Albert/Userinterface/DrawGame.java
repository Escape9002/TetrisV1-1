package com.Albert.Userinterface;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;


public class DrawGame extends JLabel{
Gui a;
	
	protected void paintComponent(Graphics g) { //Kein Rückgabewert Methode ist durch Protected auch in vererbten Klassen verwendbar sonst wäre sie nur im Package verwendbar
		
		super.paintComponent(g); //Übergabe des  Graphics Objektes g
		
		g.setColor(Color.LIGHT_GRAY); //Farbe HellGrau
		
		
		for (int x=0; x<a.anzahlbreite; x++) { //Zeichen des Rasters Größe auf dem Gameboy //Breite des Rasters 10
			for(int y=0; y<a.anzahlhöhe; y++) { //Höhe 18
				g.drawRect(x*(a.width/10), y*(a.height/18), (a.width/10), (a.height/18)); //Höhe und Breite aus Gui geplant
				
			}
			
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 10*32, 18*32);
		
		
		
		repaint(); //"neuzeichnen/akktualisieren"
		
		


	}
	
	
	
	
	
}
