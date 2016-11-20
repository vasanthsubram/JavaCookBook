package core.strings.regex.matching;

import static org.junit.Assert.assertTrue;

public class OptionalMatching {

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
	}
}
