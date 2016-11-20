package sound;
 
import java.applet.*;
import java.net.*;
 

public class PlaySoundFile {

	public static void main(String args[]) {

		String soundFiles[] = { "file:///WINNT/Media/Windows Logon Sound.wav",
				"file:///WINNT/Media/Windows Logoff Sound.wav" };

		for (int i = 0; i < soundFiles.length; i++) {

			System.out.println("Playing sound file: " + soundFiles[i]);

			try {
				URL soundFile = new URL(soundFiles[i]);
				Applet.newAudioClip(soundFile).play();
			} catch (Exception e) {
				System.err.println(e);
			}
			System.out.println("Completed sound file: " + soundFiles[i] + "\n");
		}
	}

}
