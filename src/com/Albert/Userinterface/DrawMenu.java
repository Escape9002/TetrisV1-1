package com.Albert.Userinterface;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

import com.Albert.game.Game;
import com.Albert.game.GameState;

public class DrawMenu extends JLabel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		if(Game.gamestate ==GameState.start) {
			g.setColor(new Color(24,70,145));
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);
			g.setColor(Color.WHITE); 
			System.out.println("Leck mich am arsch");
			//Startbildschirm
			g.drawString("Enter zum spielen", Gui.width /2, Gui.height /2+10);
		}else if(Game.gamestate == GameState.pause) {
			g.setColor(Color.CYAN);
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);
			g.setColor(Color.WHITE); 
			
			//Pausemenue
			g.drawString("Esc to continue", Gui.width /2 -10, Gui.height /2+10);
		}else if(Game.gamestate ==GameState.gameover) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, Gui.height /2 -50, Gui.width +200 , 100);
			g.setColor(Color.WHITE); 
			
			//Ende
			g.drawString("You Lost. Enter to play again", 75, Gui.height /2+10);
		}
 		
		repaint();
	}	
	
	
	
	
}
