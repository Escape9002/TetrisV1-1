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

public class Audio{
	
	public static synchronized void musikplay(String name, boolean permanent, int volumered) {
		
		
	final String trackname = name;
	final boolean permaloop = permanent;
	final int volumestate = volumered;
	
	
	
	
	new Thread(new Runnable() {
		
		public void run() {
			
			while(true) {//also immer {
			
				try {
					
					Clip clip1 = AudioSystem.getClip();
					AudioInputStream inputstream =AudioSystem.getAudioInputStream(new File(trackname));
					clip1.open(inputstream);
					
					FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(volumestate*-10f);
					
					if(permaloop == true) {
					clip1.loop(Clip.LOOP_CONTINUOUSLY);
					Thread.sleep(clip1.getMicrosecondLength()/1000);
					} else {
			        clip1.stop();
					}
					
					
					
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
			}
		}
	}).start();
	}
}
