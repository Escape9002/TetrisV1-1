package com.Albert.inout;

/* von Escape9022 inspiriert : https://github.com/Escape9002/RunningWIlbert/blob/master/RunningWilbert/src/com/game/RunningWilbert/AudioPlayer.java
 * 
 * 
 * 
 */

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

public class Audio{
	
	
	public Audio() {
	}
	
	public static void play(String filepath, boolean perma, int volume) {
		
		try {
		
		File musicPath = new File(filepath);
		if(musicPath.exists()) {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume*-10f);
			
			if(perma == true) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				while(clip.isRunning()) {}
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "couldnt find the file");
		}
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
	}
}
