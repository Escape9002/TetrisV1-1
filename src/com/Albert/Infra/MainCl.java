package com.Albert.Infra;

import com.Albert.Userinterface.Gui;
import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.inout.Backgroundplayer;

public class MainCl {

	
	
	
	
	
	public  static void main(String[] args) {          //Main Methode
		
		Game.currentBlock =new Block();  
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock =new Block();
		
		
		Gui g = new Gui(); //Erstellen des  GUIS Objekts
		g.create(); //Das Gui zeichnen
		
		Backgroundplayer b = new Backgroundplayer();
		b.startmusik();
		
		
		
		startLoop(); // Ausführen der Methode GameLoop( weiter unten)
		
	}
	
	public static void startLoop() {
		
		GameLoop loop =new GameLoop(); // Erzeugen des Gameloop Objektes
		loop.start(); //Start Methode der Gameloop
	
	}
	
	
}
