package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*** Adding certificate ****/
// keytool -import -keystore "C:/Program Files/Java/jre1.8.0_102/lib/security/cacerts" -trustcacerts -alias "alcatraz cert1" -file "C:\Program Files\Java\jre7\lib\security\alcatraz.cer"
// "C:/Program Files/Java/jre7/lib/security/usciscert.cer"
//  password: changeit

//delete alcatraz cert

public class CheckAlcatrazTickets {
	public static void main(String[] args) {

		try {
			// get URL content

			while (true) {
				try {

					boolean flag = checkStatus();
					if (flag) {
						//System.out.println("Status Changed");
						while (true) {
							TimeUnit.SECONDS.sleep(5);
							playSound();
						}

					}
					
					
					TimeUnit.SECONDS.sleep(30);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean checkStatus() throws MalformedURLException,
			IOException {
		String a = "https://www.alcatrazcruises.com/SearchEventDaySpan.aspx?date=09-08-2016&qty=3";

		URL url = new URL(a);
		URLConnection conn = url.openConnection();

		// open the stream and put it into BufferedReader
		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));

		String inputLine;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		boolean flag = false;
		while ((inputLine = br.readLine()) != null) {

			if (inputLine
					.contains("available=")) {
				System.out.println(inputLine);
				System.out.println("Tickets available");
				flag = true;

			}
		}
		return flag;
	}

	private static void playSound() throws IOException {
		System.out.println("Tickets available");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));

		// Open an audio input stream.
		File soundFile = new File("Casio-MT-600-Synth-Bells-C3.wav");
		try {
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(soundFile);
			Clip clip;

			clip = AudioSystem.getClip();

			// Open audio clip and load samples from the audio input
			// stream.

			clip.open(audioIn);
			clip.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}