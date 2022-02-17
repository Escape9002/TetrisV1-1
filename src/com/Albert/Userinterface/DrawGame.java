package com.Albert.Userinterface;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.Albert.Data.Conversion;
import com.Albert.game.Block;
import com.Albert.game.Game;

public class DrawGame extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				g.drawRect(i * 32, j * 32, 32, 32);
			}
		}


		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 320	, 576);

		
		g.setColor(Game.currentBlock.getColor());
		for (int j = 0; j < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()].length; j++) {
			
			for (int k = 0; k < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j].length; k++) {
			
				if (Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j][k] == 1) {
					g.fillRect(Conversion.cellToCoord(Game.currentBlock.getX() + j),
							Conversion.cellToCoord(Game.currentBlock.getY() + k), 32, 32);
			
					
				}
			}
		}

		repaint();
	}

}