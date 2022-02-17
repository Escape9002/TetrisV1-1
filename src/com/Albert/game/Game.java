package com.Albert.game;

import java.util.ArrayList;



public class Game {


	public static int score =0;
	
	public static int highscore =0;
	public static int scoreToAdd =0;
	public static boolean spawnNewBlock =true;
	public static boolean speedup =false;
	
	public static ArrayList<Block> blocks =new ArrayList<Block>();
	public static Block currentBlock;
	public static Block nextBlock;
	
	public static int[][] map =new int[10][18];
	
	public static GameState gamestate = GameState.ingame;
	
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
