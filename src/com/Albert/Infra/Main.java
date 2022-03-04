package com.Albert.Infra;
/* Imports
import java.awt.FontFormatException;
import java.io.IOException;
*/

import com.Albert.Userinterface.Gui;
import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.inout.Audio;
//import com.Albert.inout.Backgroundplayer;
import com.Albert.inout.DataHandler;

/* Main Klasse, die das Spiel startet */

public class Main {
	public  static void main(String[] args) {   
		
		DataHandler.load(); // Laden des Highscore aus vorherigen Spielständen (save.txt)
		
		
		Game.currentBlock = new Block();   // Den Current Block zum Start generieren
		Game.blocks.add(Game.currentBlock); // Den ersten Current Block in die Arraylist aller Blöcke eintragen
		Game.nextBlock = new Block(); //Den next Block generieren
		
		try {
			Gui g = new Gui(); //Gui Objekt erstellen und die Methode create des Spielfelds wird ausgeführt
			g.create();
		} catch (Exception e) {
			System.out.println("GUI failed"); //debug
			e.printStackTrace();
		}
		
		/* Mussik */
		
		Audio.play("rsc/Music/backgroundmusik.wav", true, 2); // Die Hintergrundmusik wird gestarten, diese ist permanent
		
		startLoop(); // Ausführen der Methode zum Starten der Gameloop (weiter unten)
		
	}

	public static void startLoop() {
		GameLoop loop =new GameLoop(); // Erzeugen des Gameloop Objektes
		loop.start(); //Start Methode der Gameloop
	}
}