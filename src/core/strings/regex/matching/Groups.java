package core.strings.regex.matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
	public static void main(String[] args) {
		//Match dates in MM/DD/YYYY format
		Pattern p = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");

		Matcher m = p.matcher("07/04/1776");
		if (m.matches()) {
			System.out.println("Month = " + m.group(1));
			System.out.println("Date = " +m.group(2));
			System.out.println("Year = " +m.group(3));
		}
	}
}
