package core.strings.regex.matching.examples;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchNumericRange0To255 {

	public static void main(String[] args) {
		//match numbers between 0 and 9
		assertTrue("0".matches("[0-9]"));
		
		//match numbers between 10 and 99
		assertTrue("23".matches("[1-9][0-9]"));
		
		//match numbers between 100 and 199
		assertTrue("123".matches("1[0-9][0-9]"));
		
		//match numbers between 200 and 249
		assertTrue("223".matches("2[0-4][0-9]"));
		
		//match numbers between 250 and 255
		assertTrue("253".matches("25[0-5]"));
		
		//combine above to => match numbers between  0 and 255
		String zeroTo255 = "[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]";
		assertTrue("100".matches(zeroTo255));
		assertTrue("255".matches(zeroTo255));
		assertFalse("256".matches(zeroTo255));
		
	}
}
