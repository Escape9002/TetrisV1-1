package com.Albert.inout;

/* 
 * Audio Player zum Abspielen der Musik und Soundeffekte w�hrend des Spieles
 * Zum Abspielen der Musik  wird der Darteipfad ( String),
 *  die Info ob er Wiederholt werden soll (boolean perma)
 * und die Lautst�rkenregulation mit Abstufungen von 10 als Int ben�tigt
 * 
 */
/* Import */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class Audio {

	public static void play(String filepath, boolean perma, int volume) { // Methode mit den �bergabe Werten f�r den Pfad, den Loop und die Lautst�rke
/*
		try {

			File musicPath = new File(filepath); // File System
			if (musicPath.exists()) { // �berpr�ft ob am angegeben Platz Musik ist
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); //
				Clip clip = AudioSystem.getClip(); // Speichern der Musik in einem Clip (Clip = VAriablentyp importiert)
				clip.open(audioInput);
				clip.start();// Abspielen des Clips

				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); // Control zum �ndern der Lautst�rke
				gainControl.setValue(volume * -10f); // �ndern der Lautst�rke

				if (perma == true) { // Falls die Musik dauerhaft abgespielt werden soll (perma = true)
					clip.loop(Clip.LOOP_CONTINUOUSLY);// Clip unendlich loopen
					// while() {} // Das war der fehler
				}

			} else {
				JOptionPane.showMessageDialog(null, "couldnt find the file"); // Exception
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR"); // Exception
		}*/
	}
}
