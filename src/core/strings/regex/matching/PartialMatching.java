package core.strings.regex.matching;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartialMatching {
	public static void main(String args[]) {
		Pattern p = Pattern.compile("Gold");
		Matcher m = p.matcher("Gold Fish");
		
		assertTrue(m.lookingAt());

		m = p.matcher("An inch of time is an inch of Gold, but you can't buy that inch of time with an inch of Gold");
		while (m.find()) {
			System.out.println("Found Gold between  " + m.start() + " and "
					+ m.end());
		}
	}
}
