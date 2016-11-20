package core.strings.regex.matching.examples;

import java.util.regex.Pattern;

public class CheckForNumericValue {

	public static void main(String[] args) {
		String test="123x";
		System.out.println(Pattern.matches("\\d*", test));
	}
}
