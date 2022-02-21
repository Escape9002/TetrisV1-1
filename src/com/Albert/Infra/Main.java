package com.Albert.Infra;

/*
import java.awt.FontFormatException;
import java.io.IOException;
*/

import com.Albert.Userinterface.Gui;
import com.Albert.game.Block;
import com.Albert.game.Game;
//import com.Albert.inout.Backgroundplayer;
import com.Albert.inout.DataHandler;

public class Main {
	public  static void main(String[] args) {          // Main Methode
		
		DataHandler.load();
		
		
		Game.currentBlock = new Block();
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock = new Block();
		
		try {
			Gui g = new Gui();
			g.create();
		} catch (Exception e) {
			System.out.println("GUI failed");
			e.printStackTrace();
		}
		
		
		
		startLoop(); // Ausführen der Methode GameLoop( weiter unten)
		
	}

	public static void startLoop() {
		GameLoop loop =new GameLoop(); // Erzeugen des Gameloop Objektes
		loop.start(); //Start Methode der Gameloop
	}
}