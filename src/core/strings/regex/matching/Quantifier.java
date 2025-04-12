package core.strings.regex.matching;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

public class Quantifier {

	public static void main(String[] args) {
		//	? => makes the preceding token optional
		
		//one character optional
		assertTrue("color".matches("colou?r"));
		assertTrue("colour".matches("colou?r"));
		
		//one set of characters optional
		assertTrue("Nov".matches("Nov(ember)?"));
		assertTrue("November".matches("Nov(ember)?"));
		
		// multiple alternatives
		assertTrue("February 23rd".matches("Feb(ruary)? 23(rd)?"));
		assertTrue("February 23".matches("Feb(ruary)? 23(rd)?"));
		assertTrue("Feb 23rd".matches("Feb(ruary)? 23(rd)?"));
		assertTrue("Feb 23".matches("Feb(ruary)? 23(rd)?"));

		//X*   X, zero or moretimes.
		assertTrue("123".matches("\\d*"));
		assertTrue("123x".matches("\\d*x"));
		assertTrue("000.12.12.034".matches("^(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})$"));



	}
}
