package com.Albert.inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.Albert.game.Game;

/* Data Handler Klasse dient der Umwandlung des Highscore aus dem savetxt und in das Savetxt */

public class DataHandler {

	public static void load() { // Load funktion um den Highscore aus dem Txt zu laden

		File savetxt = new File("rsc/save.txt"); // FileSystem

		try {
			Scanner sc = new Scanner(savetxt); // Scanner der das TXT ausliest
			Game.highscore = sc.nextInt(); // Speichern der Information
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void save() { // Save Funktion um den Highscore in das TXT zu schreiben falls dieser höher ist

		File savetxt = new File("rsc/save.txt"); // File System

		try {
			OutputStream stream = new FileOutputStream(savetxt);
			try {
				stream.write(Integer.toString(Game.highscore).getBytes()); // Schreiben des neuen Highscore in das TXT
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

}
