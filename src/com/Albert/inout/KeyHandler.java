package com.Albert.inout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.Albert.Data.Collision;
import com.Albert.game.Game;
import com.Albert.game.GameState;

public class KeyHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) { // wird eigentlich nicht benoetigt
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	  if(Game.gamestate == GameState.start)
	  {
		  if(e.getKeyCode() == KeyEvent.VK_Q) {
			  
			  Game.gamestate = GameState.ingame;
			    System.out.println("q unnd " + Game.gamestate);
		  }
      }
	  
	  
	  if(Game.gamestate == GameState.ingame) {
		  
		  if(e.getKeyCode() == KeyEvent.VK_SPACE)
		  {
			  if(!Collision.collideInRotation(Game.currentBlock))
			  {
			  	Game.currentBlock.rotate();}
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_DOWN)
		  {
			  Game.speedup = true;
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		  {
			  
			  if(!Collision.collideWithWall(Game.currentBlock, 1) && !Collision.collideWithBlock(Game.currentBlock, 1))
					  {
				  
			 Game.currentBlock.setX(Game.currentBlock.getX() +1 );
			 }
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_LEFT)
		  {
			  
			  if(!Collision.collideWithWall(Game.currentBlock, -1 )&&!Collision.collideWithBlock(Game.currentBlock, -1 )){
			  Game.currentBlock.setX(Game.currentBlock.getX() -1 );
			  }
		  }
		  
		  if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		  {
			  Game.gamestate =GameState.pause;
		  }
		  
		  
	  }else if(Game.gamestate == GameState.pause) {
		  
		  if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			  Game.gamestate = GameState.ingame;
		  }
		  
	  }else if(Game.gamestate ==GameState.gameover) {
		  
		  if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			  Game.gamestate = GameState.ingame;
			  Game.clear();
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
