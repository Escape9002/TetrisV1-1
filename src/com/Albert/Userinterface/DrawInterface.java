package com.Albert.Userinterface;
/*imports */
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
				g.drawRect(x*32+32, y*32, 32, 32); //zeichnen der einzelnen Rechtecke
				
			}
			
		}
	   g.setColor(Color.BLACK); // Farbe änder auf Schwarz für den äußeren Rand
	   g.drawRect(32, 0, 4*32, 4*32); //Zeichnen eines Rechtecks außenrum
	
	   
		
	   g.setColor(Game.nextBlock.getColor()); //Farbe auf den neuen Block setzten 
		
		
		
		/* Zeichnen des neuen Blockes im oberen Feld */
		
		for(int i=0; i<Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length ;i++) {    		//Jede Zelle des Blockes durchgehen 1. Schleife x
			for(int j=0; j<Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i].length; j++) { //Jede Zelle des Blocks durchgehen 2 Schleife y
				if(Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i][j] ==1) { //  Luft Teile des Blockes werden nicht gezeichnet
		         
					g.fillRect(Conversion.cellToCoord(1 +i),  // Zeichnen der ausgefüllten Blöcke nicht Luft Blöcke
							    Conversion.cellToCoord(j),
							    (32),(32));
			//System.out.println("s"); //debug
				}
				
			}
		}
		
		g.setColor(Color.BLACK); //Farbe für den Highscore
		g.drawString("Punkte:   " + Game.score, 32 , 200); // Zeichnen des Scores 
		g.drawString("Highscore. "+ Game.highscore, 32, 250 );//Zeichnen des Highscore
		
		
		repaint(); //"neuzeichnen/akktualisieren"

	}
	
}