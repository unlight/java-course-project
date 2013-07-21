package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class StringUtils {

	public static String randomPicture(int width, int height, String category) {
//		http://lorempixel.com/120/160/people/
		return null;
	}

	public static String randomPhone() {
		StringBuilder sb = new StringBuilder(10);
		Random generator = new Random();
		sb.append("(");
		sb.append(100 + generator.nextInt(900));
		sb.append(") ");
		sb.append(100 + generator.nextInt(900));
		sb.append("-");
		sb.append(10 + generator.nextInt(90));
		sb.append("-");
		sb.append(10 + generator.nextInt(90));
		return sb.toString();
	}

	public static Date randomDate() {
		Random generator = new Random();
		int year = 1970 + generator.nextInt(30);
		int month = generator.nextInt(12);
		int day = generator.nextInt(28);
		Date result = new Date(year, month, day);
		return result;
	}

	public static String loremWord() {
		String s = loremParagraph();
		String[] split = s.split("( |,|\\.|\\?|;|\\:)");
		Random generator = new Random();
		int index = generator.nextInt(split.length);
		if (index >= split.length) {
			index = split.length - 1;
		}
		s = split[index];
		char first = 0;
		try {
			first = Character.toUpperCase(s.charAt(0));
			s = first + s.substring(1);
		} catch (StringIndexOutOfBoundsException e) {
			s = "None";
		}
		return s;
	}

	public static String loremParagraph() {
		URL url = null;
		try {
			url = new URL("http://loripsum.net/generate.php?p=1&l=short");
		} catch (MalformedURLException ex) {
		}
		URLConnection con;
		String html = "";
		try {
			con = url.openConnection();
			con.setReadTimeout(1000);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
			in.close();
			html = sb.toString();
		} catch (IOException ex) {
		}
		if ("".equals(html)) {
			return "";
		}
		html = html.replaceAll("\\<.*?\\>", "");
		return html;
	}

	public static String join(Collection<String> c, String d) {
		String[] strings = c.toArray(new String[c.size()]);
		return join(strings, d);
	}

	public static String join(String r[], String d) {
		if (r.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < r.length - 1; i++) {
			sb.append(r[i]).append(d);
		}
		return sb.toString() + r[i];
	}
}
