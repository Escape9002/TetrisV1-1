package com.Albert.inout;

/* 
 * Audio Player zum Abspielen der Musik und Soundeffekte während des Spieles
 * Zum Abspielen der Musik mit die Methode wird der Darteipfad ( String),
 *  die Info auf er Wiederholt werden soll (boolean perma)
 * und die Lautstärkenregulation mit Abstufungen von 10 als Int benötigt
 * 
 */
/* Import */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class Audio{ 

	
	
	public static void play(String filepath, boolean perma, int volume) { // Methode mit den Übergabe Werten für den Pfad, den Loop und die Lautstärke 
		
		try {
		
		File musicPath = new File(filepath); // File System
		if(musicPath.exists()) {  // Überprüft ob am angegeben Platz Musik ist
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); // 
			Clip clip = AudioSystem.getClip(); // Speichern der Musik in einem Clip (Clip = VAriablentyp importiert)
			clip.open(audioInput);
			clip.start();//Abspielen des Clips
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); // Control zum Ändern der Lautstärke
			gainControl.setValue(volume*-10f); // Ändern der Lautstärke
			
			if(perma == true) { // Falls die Musik dauerhaft abgespielt werden soll (perma = true)
				clip.loop(Clip.LOOP_CONTINUOUSLY);// Clip unendlich loopen
		//while()    {}  // Das war der  fehler
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "couldnt find the file"); //Exception
		}
			
			
		}catch (Exception e) { 
			JOptionPane.showMessageDialog(null, "ERROR"); // Exception
		}
	}
}
