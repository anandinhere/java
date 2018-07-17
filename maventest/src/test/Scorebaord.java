package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.StatusLine;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.nodes.Document;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jsoup.Jsoup;

public class Scorebaord {
	public static void main(String[] args) {

		/*
		 * try { test2(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

		try {
			test2();
			getScore();
			test();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * JFrame frame = new JFrame("Hello!!");
		 * 
		 * // Set's the window to be "always on top" frame.setAlwaysOnTop(true);
		 * 
		 * frame.setLocationByPlatform(true); frame.add(new JLabel(getScore()));
		 * frame.pack(); frame.setVisible(true);
		 */
	}

	private static void test() {
		Document doc;
		try {
			doc = Jsoup
					.connect(
							"http://www.cricbuzz.com/live-cricket-scores/18121/srh-vs-rcb-1st-match-indian-premier-league-2017/")
					.get();
			String text = doc.body().text();
			System.out.print(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String test2() throws IOException {

		StringBuilder sb = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(
				"http://www.espncricinfo.com/indian-premier-league-2017/engine/match/1082591.html");
		try {
			HttpResponse response = client.execute(httpget);
			int sc = response.getStatusLine().getStatusCode();
			if (sc == 200) {
				HttpEntity ent = response.getEntity();
				InputStream inpst = ent.getContent();
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						inpst));
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
			} else {
				System.out.println("log_tag, I didn't  get the response!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb);
		return sb.toString();

	}

	private static String getScore() throws MalformedURLException, IOException {
		String a = "http://www.espncricinfo.com/indian-premier-league-2017/engine/match/1082591.html";

		URL url = new URL(a);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		System.out.println(conn.getResponseCode());

		// open the stream and put it into BufferedReader
		BufferedReader br = null;

		if (((HttpURLConnection) conn).getResponseCode() == 200) {
			br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
		} else {
			br = new BufferedReader(new InputStreamReader(
					((HttpURLConnection) conn).getErrorStream(), "UTF-8"));
		}

		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			System.out.println(inputLine);
			if (inputLine.contains("title")) {
				return inputLine;

			}
		}
		return "";
	}

}
