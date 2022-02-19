package com.Albert.Infra;

import com.Albert.Data.Collision;
import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.game.GameState;

public class GameLoop extends Thread{
	private boolean running =true;
	
	public void run() {
		while(running ) {
			try {
			if(Game.gamestate == GameState.ingame) {
				
				if(!Collision.collideWithWall(Game.currentBlock, 0) && !Collision.collideWithBlock(Game.currentBlock, 0)) //Zweimal aufgerufen also vier zeilen drunter, damit man ihn in der untersten Ebene nicht bewegen kann, aber auf Blöcken bewegen kann
				{
					System.out.println("d");
					Game.currentBlock.setY(Game.currentBlock.getY() + 1);
					Collision.collideWithWall(Game.currentBlock, 0);
				}
				
				
			

				if(Game.spawnNewBlock) {
					
					Game.blocks.add(Game.nextBlock);
					Game.currentBlock = Game.nextBlock;
					Game.nextBlock = new Block();
					Game.spawnNewBlock = false;
					System.out.println("IF of gameLoop");
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
}
}