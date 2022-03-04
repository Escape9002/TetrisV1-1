package com.Albert.Infra;

import com.Albert.Data.Collision;
import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.game.GameState;

public class GameLoop extends Thread{
	private boolean running =true;
	
	public void run() {
		while(running) {
			try {
		
			System.out.println("man");
			if(Game.gamestate == GameState.ingame) {
				
				if(!Collision.collideWithWall(Game.currentBlock, 0) ) 
				{
					if(!Collision.collideWithBlock(Game.currentBlock, 0)) {
					System.out.println("d");
					
					Game.currentBlock.setY(Game.currentBlock.getY() + 1);
					}			
				}
				
				
			

				if(Game.spawnNewBlock) {
					Collision.checkFullRow(1);
					Game.blocks.add(Game.nextBlock);
					Game.currentBlock = Game.nextBlock;
					Game.nextBlock = new Block();
					Game.spawnNewBlock = false;
					System.out.println("IF of gameLoop");
				}
			}
			if(!Game.speedup) {
				if(java.lang.Math.round(1000 - (0.001 * Game.blocks.size())) > 100 ) {
					
				sleep(java.lang.Math.round(1000 - (0.001 * Game.blocks.size())) );//zeit ändern
				System.out.println("Speed " + java.lang.Math.round(1000 - (0.001 * Game.blocks.size())));
				}else {
					sleep(100);
				}
				
			}else {
				sleep(100);
			}
		System.out.println(Game.blocks.size());
		System.out.println(Game.currentBlock.getY());
		}catch(InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	}}
