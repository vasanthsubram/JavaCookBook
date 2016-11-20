package core.strings.regex.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplacingGroups {

	public static void main(String[] args) {

		String input ="The yo-yo goes up, down, up, down";
		String w1="up",w2="down";
		String regex = "\\b(" + w1+ ")(\\W+)(" + w2 + ")\\b";
		
		Matcher m = Pattern.compile(regex).matcher(input);
		System.out.println(m.replaceAll("$3$2$1"));
	}
}
