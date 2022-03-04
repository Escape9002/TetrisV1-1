package com.Albert.game;

import java.util.ArrayList;

/* 
 * Hauptklasse des eigentlichen Spiels, hier werden alle wichtigen Variablen deklariert und alles zusammengefügt
 */

public class Game {

	public static int score = 0; // Initialisiert den Score

	public static int highscore = 0; // Initialisiert den HighScore
	public static int scoreToAdd = 0; // Initialisiert den ScoretoAdd
	public static boolean spawnNewBlock = true; // Initialisiert den boolean ob ein neuer Block gespawnt wird
	public static boolean speedup = false; // Initialisiert den boolen für das speed up (beschleunigung des Spiel)

	public static ArrayList<Block> blocks = new ArrayList<Block>(); // Variable zum speichern aller Blöcke eines Spiel in einer Arraylist
	public static Block currentBlock; // Variable für den currentBlock
	public static Block nextBlock; // Variable für den nächsten Block

	public static int[][] map = new int[10][18]; // 2dimensionales Map Array mit der größe des Spielfelds (10 im x Wert und 19 im y Wert)

	public static GameState gamestate = GameState.start; // Variable für den Gamestatus. Anfangs auf Start gesetzt

	public static void clear() {// Methode zum Neustart des Spiels (Gameover) , die Map wird geleert und der Score zurückgesetzt.

		for (int x = 0; x < map.length; x++) // Schleife zum durchlaufen aller x Werte der Map
		{
			for (int y = 0; y < map[x].length; y++) // Schleife zum durchlaufen aller y Werte der Map
			{
				map[x][y] = 0; // Werte der MAp af null setzten
			}

		}

		score = 0; // Zurücksetzten des Scores

	}

}
