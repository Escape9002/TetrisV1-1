package com.Albert.inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;





import com.Albert.game.Game;

public class DataHandler {

	public static void load() { //Load funktion
	
		File savetxt =new File("rsc/save.txt");
		
		
		try {
			Scanner sc =new Scanner(savetxt);
			Game.highscore = sc.nextInt();
			sc.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void save() {
		
		File savetxt = new File("rsc/save.txt");
		
		try {
			OutputStream stream = new FileOutputStream(savetxt);
			try {
				stream.write(Integer.toString(Game.highscore).getBytes());
				stream.close();
			}catch(IOException e) {
				e.printStackTrace();
				
			}}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		  }
	}
	
	
}
