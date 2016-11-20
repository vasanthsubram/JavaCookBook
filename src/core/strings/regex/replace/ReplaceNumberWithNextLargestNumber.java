package core.strings.regex.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceNumberWithNextLargestNumber {

	public static void main(String[] args) {
		String primes = "2 3 5 7 11 13 17 19 23 29 31 37 41";
		Pattern p = Pattern.compile("[-+]?[0-9]+");
		Matcher m = p.matcher(primes);
		StringBuffer buf = new StringBuffer();

		while (m.find()) {
			String numStr = m.group();
			int num = Integer.parseInt(numStr);
			String plusOne = Integer.toString(num + 1);
			m.appendReplacement(buf, plusOne);
		}
		m.appendTail(buf);
		System.out.println(buf.toString());

	}

}
