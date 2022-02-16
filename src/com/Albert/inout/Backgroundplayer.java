package com.Albert.inout;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Backgroundplayer {

   /* public static synchronized void sounds(String track) {

        final String trackname = "rsc/music/backgroundmusik.mp3";

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(trackname));
                        clip.open(inputStream);

                        if (Var.movementdetected == 1) {

                            clip.loop(1);

                            }


                        Thread.sleep(clip.getMicrosecondLength() / 500);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    } */

	public void startmusik() {
		// TODO Auto-generated method stub
		private Clip GetAudioClip(String path)
		{
			File audioFile = new File(path);
			if (!audioFile.exists())
			{
				return null;
			}

			try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile))
			{
				Clip audioClip = AudioSystem.getClip();
				audioClip.open(audioStream);
				FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
				float gainValue = (((float) config.volume()) * 40f / 100f) - 35f;
				gainControl.setValue(gainValue);

				return audioClip;
			}
			catch (IOException | LineUnavailableException | UnsupportedAudioFileException e)
			{
				log.warn("Error opening audiostream from " + audioFile, e);
				return null;
			}
		
		 

		
		
		
		
		
	}

}

