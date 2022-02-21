package com.Albert.Data;

import com.Albert.game.Block;
import com.Albert.game.Game;
import com.Albert.game.GameState;
import com.Albert.inout.DataHandler;

public class Collision {

	public static boolean collideWithBlock(Block b, int direction) {
		// direction: -1 = links, 0 = runter, 1 = rechts

		switch (direction) {
		case -1:
			if (b.getY() > 0) {
				if (b.getX() > 0) {
					for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
						for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
							if (b.getBounds()[b.getRotation()][i][j] == 1) {
								if (Game.map[b.getX() + i - 1][b.getY() + j] >= 1) {
									System.out.println("links");
									return true;
								}
							}
						}
					}

				}
			}
			break;
		case 0:
			if (b.getY() + b.getSize() > 1) {
				if (b.getY() - b.getSize() < 17) {
					try {
						for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
							for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
								if (b.getBounds()[b.getRotation()][i][j] == 1) {

									if (Game.map[b.getX() + i][b.getY() + j + 1] >= 1) {

										Game.spawnNewBlock = true;
										fillBlock(b);
										System.out.println("unten/oben");
										return true;
									}

								}
							}
						} 
					} catch (Exception e) {
						return false;
					}
				}
			}

			break;
		case 1:
			if (b.getY() > 0) {
				if (b.getX() < 10) {
					for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
						for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
							if (b.getBounds()[b.getRotation()][i][j] == 1) {
								if (Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {

									System.out.println("rechter Rand");
									return true;
								}
							}
						}
					}

				}
			}
			break;
		}

		return false;
	}

	/*
	public static boolean collideWithBlock(Block b, int direction) { // Guckt nach der Kollison mit anderen Blöcken
		
		
		switch(direction) {
		
		case -1:   //Linke Richtung
			if(b.getY() > 0 && b.getX() > 0) {
				for(int x =0; x < b.getBounds()[b.getRotation()].length; x++) {                          //dDIe beiden Schleifen iterieren durch den ganzen TetrisBlock, der aus mehreren einzelnen Blöcken besteht
					for(int y =0; y < b.getBounds()[b.getRotation()].length; y++)
					{
						if(b.getBounds()[b.getRotation()][x][y] ==1) {                    // Besteht der Block an dieser Stelle also weiß oder farbig
							if(Game.map[b.getX() + x -1][b.getY() + y] >= 1) {
								
						
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
								
								return true;
							}
						}
					}
				}
				
			}
			break;	
			
			
			
			
			
			
			
			
		}return false;
	}
		
		
		*/
		
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
			checkFullRow(1); 
			System.out.println("Checkfullrow");
			checkLoose();
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
	  block.setX(b.getX()+2);
	 
	  if(collideWithWall(block, -1)) {
		  return true;
	  }
	  
	  
	  
	  
	  
	  if(b.getY() > 0) {
	  try {
		for(int x =0; x < b.getBounds()[rot].length; x++) {                         
				for(int y =0; y < b.getBounds()[rot].length; y++)
				{
					if(b.getBounds()[b.getRotation()][x][y] ==1) {                    
						
						if(Game.map[b.getX() +x-1][b.getY()+y] >=1) {
							
							return true;
						}
						
						
						}
					}
				}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return true;
	}
		}
	  
	  
	  
	  
	  
	 return false;
	 
	 
 }
		
	public static void checkFullRow( int multiplier) {
		
		int blocksInRow = 0; //Zähler ob die Reihe voll ist
		
		for(int y = Game.map[0].length -1; y >0 ; y--) {
			for(int x = 0; x < Game.map.length; x++) {
				if(Game.map[x][y] > 0) {
					
					blocksInRow = blocksInRow ++;
					
				}
				
				
				
			}
			
		if(blocksInRow == 10) {
			Game.scoreToAdd = Game.scoreToAdd + (10*multiplier);
			deleteRow(y, multiplier);
			break;
			
		}else {
			blocksInRow = 0;
		}
		}
	Game.score = Game.score +Game.scoreToAdd;
	Game.scoreToAdd = 0;
	
	if(Game.score > Game.highscore) {
		Game.highscore =Game.score;
		DataHandler.save();
	}
		
		
		
	}
		
	
	
	
	
	
		
	private static void deleteRow(int row, int multiplier) {
		
		for(int x = 0; x< Game.map.length; x++) {
			
			Game.map[x][row] = 0;
			
		}
		
		
		for(int y =row; y > 1; y--) {
			
			for(int x =0; x < Game.map.length; x++) {
				
				Game.map[x][y] = Game.map[x][y- 1];
			}
		}
		checkFullRow(multiplier +1);
		
	}
	
	
	
	
	
	
		
	private static void checkLoose() {
		
		for(int i = 0; i< Game.map.length; i++) {
			if(Game.map[i][0] > 0) {
				
				Game.gamestate = GameState.gameover;
			}
		}
		
	}
		
		
	
	
	
	
}
