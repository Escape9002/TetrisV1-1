package com.Albert.inout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.Albert.Data.Collision;
import com.Albert.game.Game;
import com.Albert.game.GameState;

/* Key Handler Klasse um die Eingabe der Tastatur zu verwalten und das SPiel zu steuern*/



public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) { // wird eigentlich nicht benoetigt ist autogeneriert
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		
	  if(Game.gamestate == GameState.start)  //Überprüfen des GameState passend zur Tastendruck
	  {
		  if(e.getKeyCode() == KeyEvent.VK_ENTER) { // Falls die enter Taste   gedrückt wird
			  
			  Game.gamestate = GameState.ingame; // Falls die Entertaste gedrückt wird, wird der Gamestate auf Ingame gesetzt, vorher wurde üperprüft ob er in einem andere Status (start) ist. 
			    System.out.println("q unnd " + Game.gamestate); 
		  }
      }
	  
	  
	  if(Game.gamestate == GameState.ingame) { //Falls sich das Spiel im "aktiven Status befindet wird auf die folgenden Eingaben reagiert
		  
		  if(e.getKeyCode() == KeyEvent.VK_SPACE) // Space Eingabe = Drehen des Blockes
		  {
			  if(!Collision.collideInRotation(Game.currentBlock)) // kollision wird überprüft 
			  {
			  	Game.currentBlock.rotate();} // wenn das Drehen möglic hist wird der Block gedreht
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_DOWN) // Pfeiltaste nach unten eingabe = Beschleunigung des Blockes (im GameLoop)
		  {
			  Game.speedup = true; // Der Boolean für die If Verzweigung im GameLoop wird auf true gesetzt 
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_RIGHT)// Pfeiltaste nach rechts = Bewegung des Blockes nach rechts
		  {
			  
			  if(!Collision.collideWithWall(Game.currentBlock, 1) && !Collision.collideWithBlock(Game.currentBlock, 1)) //Kollision mit anderen Blöcken und Wänden bei Bewegung wird überprüft (nur rechts)
					  {
				  
			 Game.currentBlock.setX(Game.currentBlock.getX() +1 ); // Falls keine Kollision vorliegt wird der Block eins nach rechts bewegt
			 }
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_LEFT) // Pfeiltaste nach links = Bewegung des Blockes nach links 
		  {
			  
			  if(!Collision.collideWithWall(Game.currentBlock, -1 )&&!Collision.collideWithBlock(Game.currentBlock, -1 )){ //Kollision mit Wan und anderen Blöcken und wänden wird überprüft (nur links)
			  Game.currentBlock.setX(Game.currentBlock.getX() -1 ); //Block wird eins nach links gesetzt
			  }
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_ESCAPE) //das sich Spiel durch die if verzweigung im Ingame Esc Taste
		  {
			  Game.gamestate =GameState.pause; // Das Spiel wird  in den Pausenstatus gesetzt, da die Esc Taste im Ingame gedrückt wurde
		  }
		  
		  
	  }else if(Game.gamestate == GameState.pause) { // Das Spiel befindet sich im Pausen Status
		  
		  if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { // Falls die Esc taste gedrückt wird
			  Game.gamestate = GameState.ingame; // Status wird wieder auf ingame gesetzt
		  }
		  
	  }else if(Game.gamestate ==GameState.gameover) { // Falls das Spiel im Gameover Status ist
		  
		  if(e.getKeyCode() == KeyEvent.VK_ENTER) { // Wenn die Enter taste gedrückt wird
			  Game.gamestate = GameState.ingame; //Status wird wieder auf ingame gesetzt
			  Game.clear(); // Die methode clear im Game wird ausgeführt um das Spiel zurückzusetzten
		  }
	  
	  }
	  
	  
		//if(Gamest)
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Game.gamestate == GameState.ingame) {
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				Game.speedup = false;
			}
		}
		
	}

	
	
	
	
	
	
	
	
}
