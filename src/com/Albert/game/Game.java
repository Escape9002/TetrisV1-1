package com.Albert.game;

import java.util.ArrayList;

import com.Albert.Userinterface.Gui;

public class Game {
static Gui c;

	public static int score =0;
	public static int highscore =0;
	public static int scoreToAdd =0;
	public static boolean spawnNewBlock =false;
	public static boolean speedup =false;
	
	public static ArrayList<Block> blocks =new ArrayList<Block>();
	public static Block currentBlock;
	public static Block nextBlock;
	
	public static int[][] map =new int[Gui.anzahlbreite][Gui.anzahlhoehe];
	
	public static GameState gamestate = GameState.start;
	
	public static void clear() { //Setzt die Map auf Null
		
	for(int x=0; x<map.length; x++)
	{
		for(int y=0; y<map[x].length; y++)
		{
			map[x][y] =0;
		}
		
	}
	
	score = 0 ;
		
	}


	
	
	
}
