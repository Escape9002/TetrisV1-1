package com.Albert.Infra;

import com.Albert.Userinterface.Gui;
import com.Albert.game.Block;
import com.Albert.game.Game;

public class MainCl {

	
	
	
	
	
	public  static void main(String[] args) {
		
		Game.currentBlock =new Block();
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock =new Block();
		
		
		Gui g = new Gui(); //Erstellen eines neuen GUIS Objekts
		g.create(); //Die Methode Create des Gui g ausführen
		
	}
	
	public static void startLoop() {
		
		GameLoop loop =new GameLoop();
		loop.start();
	}
	
	
}
