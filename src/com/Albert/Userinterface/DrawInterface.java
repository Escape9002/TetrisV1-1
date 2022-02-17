package com.Albert.Userinterface;

import javax.swing.JLabel;

import com.Albert.Data.Conversion;
import com.Albert.game.Game;

import java.awt.Color;
import java.awt.Graphics;


public class DrawInterface extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	



	protected void paintComponent(Graphics g) { //Kein Rueckgabewert Methode ist durch Protected auch in vererbten Klassen verwendbar sonst waere sie nur im Package verwendbar
		
		super.paintComponent(g); //Uebergabe des  Graphics Objektes g
		
		g.setColor(Color.LIGHT_GRAY); //Farbe HellGrau
		
		
		for (int x=0; x<4; x++) { //Zeichnen des Feldes fuer den kommenden Blockes 4x4
			for(int y=0; y<4; y++) { 
				g.drawRect(x*32+32, y*32, 32, 32); 
				
			}
			
		}
	   g.setColor(Color.BLACK);
	   g.drawRect(32, 0, 4*32, 4*32); //Zeichnen eines Rechtecks auszern rum
		
		
	   g.setColor(Game.nextBlock.getColor()); //Farbe auf den neuen Block setzten 
		
		
		
		/* Zeichnen des neuen Blockes im oberen Feld */
		
		for(int i=0; i<Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length ;i++) {    		
			for(int j=0; j<Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i].length; j++) {
				if(Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i][j] ==1) {
		         
					g.fillRect(Conversion.cellToCoord(1 +i), 
							    Conversion.cellToCoord(j),
							    (32),(32));
			//System.out.println("s");
				}
				
			}
		}
		
		repaint(); //"neuzeichnen/akktualisieren"

	}
	
}