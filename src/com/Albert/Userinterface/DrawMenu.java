package com.Albert.Userinterface;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

import com.Albert.game.Game;
import com.Albert.game.GameState;

public class DrawMenu extends JLabel {

	/*
	 * Menü Klasse für den Start, Pausen und Gameover Screen
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/* Welcher screen gezeichnent wird hängt vom Gamestate ab*/
		
		if(Game.gamestate ==GameState.start) {  // Zeichnen des Starbildschirm mit Farbband und Text
			g.setColor(new Color(24,70,145));//Farbe
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);//band
			g.setColor(Color.WHITE); //Textfarbe
			System.out.println("Leck mich am arsch");//debug
			//Startbildschirm
			g.drawString("Enter zum spielen", Gui.width /2, Gui.height /2+10);// Text
		}else if(Game.gamestate == GameState.pause) { // Zeichnen des Pause Menü
			g.setColor(Color.CYAN);//farbe
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);//band
			g.setColor(Color.WHITE); //Textfarbe
			
			//Pausemenue
			g.drawString("Esc to continue", Gui.width /2 -10, Gui.height /2+10);//Text
		}else if(Game.gamestate ==GameState.gameover) { //zeichnen des Gameoverscreens
			g.setColor(Color.DARK_GRAY);//Farbe
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);//band
			g.setColor(Color.WHITE); //textfarbe
			
			//Ende
			g.drawString("You Lost. Enter to play again", 75, Gui.height /2+10);//text
		}
 		
		repaint();// aktualisieren/neuzeichnen
	}	
	
	
	
	
}
