package com.Albert.Infra;

import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.game.GameState;

public class GameLoop extends Thread{

	private boolean running =true;
	
	
	public void run() {
		
		while(running==true) {
			try {
			if(Game.gamestate ==GameState.start) {
				
				Game.currentBlock.setY(Game.currentBlock.getY() +1);
				
				
				
				if(Game.spawnNewBlock) {
					
					Game.blocks.add(Game.nextBlock);
					Game.currentBlock =Game.nextBlock;
					Game.nextBlock =new Block();
					Game.spawnNewBlock =false;
					
					
					
					
				}
			}
			
			if(!Game.speedup) {
				sleep(1000);
			}else {
				sleep(100);
			}
			
			
		}catch(InterruptedException e) {
			
			e.printStackTrace(); 
			
		}
		
		
		
	}
	
	
	
}}
