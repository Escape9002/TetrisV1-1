package com.Albert.Data;

import com.Albert.game.Block;
import com.Albert.game.Game;

public class Collision {

	
	public static boolean collideWithBLock(Block b, int direction) { // Guckt nach der Kollison mit anderen Blöcken
		
		
		switch(direction) {
		
		case -1:   //Linke Richtung
			if(b.getY() > 0 && b.getX() > 0) {
				for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
					for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
					{
						if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
							if(Game.map[b.getX() + x -1][b.getY() + y] >= 1) {
								
								System.out.println("links");
								return true;
								
							}
						}
					}
				}
				
			}
			break;
	
			
			
			
			
		case 0:	//Kollison Richtung Unten
			if(b.getY() + b.getSize()  > 1 && b.getY() - b.getSize()  < 1) { //prüft nach oben und unten
				try {
					for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
						for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
						{
							if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
								if(Game.map[b.getX() + x ][b.getY() + y +1] >= 1) {
									Game.spawnNewBlock = true;
									
									fillBlock(b);
									
									System.out.println("unten/oben");
									return true;
								}
							}
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			break;
			
		
			
		case 1:   //Rechte Richtung
			if(b.getY() > 0 && b.getX() < 10) {
				for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
					for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
					{
						if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
							if(Game.map[b.getX() + x +1][b.getY() + y] >= 1) {
								
								System.out.println("rechter Rand");
								return true;
							}
						}
					}
				}
				
			}
			break;	
			
			
			
			
			
			
			
			
		}return false;
	}
		
		
		
		
		private static void fillBlock(Block b) {  //Fügt den Block sobald er unten ist in das MAp array (befindet sich in der Game Klasse) ein
			
			
			try {
				for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
					for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
					{
						if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
							
							
							Game.map[b.getX() + x][b.getY() + y] = b.getTypeValue();
							
							
							
							
							
							}
						}
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
	
		public static boolean collideWithWall(Block b, int direction) { // Guckt nach der Kollison mit den Seiten
			
			
			switch(direction) {
			
			case -1:   //Linke Wand
				
					for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
						for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
						{
							if(b.getBounds()[b.getRotation()][x][y] ==1) {                    
								if(b.getX() +1 == 0) {
																	
									System.out.println("links Wand");
									return true;
								}
								}
							}
						}
					
					
				
				break;
		
				
				
				
				
			case 0:	
			
		
						for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
							for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
							{
								if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
									if(b.getY() + y == 17) {
										Game.spawnNewBlock = true;
										
										fillBlock(b);
										
										System.out.println("Ende unten");
										return true;
									}
								}
							}
						}
					
						break;
				
			
				
			case 1:   //Rechte Richtung
			
					for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
						for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
						{
							if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
								if(b.getX() + (x+2) >= 11) {
									
									System.out.println("rechter Wand");
									return true;
								}
							}
						}
					}
					
				
				break;	
				
				
				
				
				
				
				
				
			}return false;
		}
		
		
		
 public static boolean collidInRotation(Block b) {
	 
	 int rot = b.getRotation() + 1;
	 
	 if(rot ==4) {
		 rot = 0;
	 }
	 
	 Block block = new Block();
	 block.setRotation(rot);
	 block.setBounds(b.getBounds());
	 block.setSize(b.getSize());
	 block.setX(b.getX() -1);
	 block.setY(b.getY());
	 
	 if(collideWithWall(block, 1)) {
		 return true;
	 }
	  block.setX(b.getX());
	 
	  if(collideWithWall(block, -1)) {
		  return true;
	  }
	  
	 return false;
	 
	 
 }
		
		
		
		
		
		
		
		
		
	
	
	
	
}
