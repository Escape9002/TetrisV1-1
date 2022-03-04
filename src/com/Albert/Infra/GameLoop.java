package com.Albert.Infra;

import com.Albert.Data.Collision;
import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.game.GameState;

/* Game Loop Klasse*/


public class GameLoop extends Thread{
	private boolean running =true;
	
	public void run() {
		while(running) {  // Whileschleife die dauerhaft solang das Spiel läuft true ist
			try {
		
			System.out.println("man");     //debug
			if(Game.gamestate == GameState.ingame) {  // Falls das Spiel sich im Ingame zustand wird dieser Teil ausgeführt (aktives Spielen)
				
				if(!Collision.collideWithWall(Game.currentBlock, 0) )  // Überprüft ob eine Block Kollision nach unten gegen den Boden vorliegt
				{
					if(!Collision.collideWithBlock(Game.currentBlock, 0)) { // Überprüft ob eine Block Kollision nach unten gegen einen anderen Block vorliegt
					
						System.out.println("d"); //debug
					
					Game.currentBlock.setY(Game.currentBlock.getY() + 1); // Da keine Kollision nach unten vorliegen, kann der Block eins weiter nach unten gesetzt werden
					}			
				}
				
				
			

				if(Game.spawnNewBlock) { // Falls durch z.b die Kollisions Klasse(wenn der alte Block in die Map eigetragen wird) der Boolean true ist wird hier der neue Block erzeugt und gespawnt
					
					Collision.checkFullRow(1); // Überprüft die Vollständigkeit der Reihen mit dem Start Multiplier 1
					Game.blocks.add(Game.nextBlock); // Der neu folgende Block (oben rechts) wird in die Arraylist aller Blöcke eingetragen
					Game.currentBlock = Game.nextBlock; // Der folgende Block wird zum CurrentBlock
					Game.nextBlock = new Block();// Der next Block wird neu generiert
					Game.spawnNewBlock = false; // Der Boolean wird wieder auf false gesetzt.
					System.out.println("IF of gameLoop"); //debug
				}
			}
			if(!Game.speedup) {// If Verzweigung je nach gewünschter Gecschwindigkeit durch z.B Tastendruck
				
				if(java.lang.Math.round(1000 - (0.01 * Game.blocks.size())) > 100 ) { // Damit das Programm nicht zu schnell wird Geschwindigkeitsmaximierung auf 100 Millisekunden
					
				sleep(java.lang.Math.round(1000 - (0.01 * Game.blocks.size())) );//Berechnen der Geschwindigkeit mit der Anzahl der Blöcke( leider gab es keine offizielle Formel
				System.out.println("Speed " + java.lang.Math.round(1000 - (0.01 * Game.blocks.size()))); // debug
				}else {
					sleep(100); // minimal Geschwindigkeit
				}
				
			}else {
				sleep(100);// Geschwindigkeit bei  Beschleunigung durch z.B. Tastendruck
				
			}
		System.out.println(Game.blocks.size()); //debug
		System.out.println(Game.currentBlock.getY()); //debug
		}catch(InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	}}
