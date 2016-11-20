package core.strings.regex.matching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RepititionMatching {
	public static void main(String[] args) {
		// X? => X appears once or not at all
		String regex = "Fishy?";
		assertTrue("Fish".matches(regex));
		assertTrue("Fishy".matches(regex));
		assertFalse("Fishyy".matches(regex));
		assertFalse("Fishyyyy".matches(regex));
		
		// X* => X appears zero or more times
		regex="Fishy*";
		assertTrue("Fish".matches(regex));  
		assertTrue("Fishy".matches(regex));
		assertTrue("Fishyy".matches(regex));
		assertTrue("Fishyyyy".matches(regex));
		
		// X+ => X appears one or more times
		regex = "Fishy+";
		assertFalse("Fish".matches(regex));
		assertTrue("Fishy".matches(regex));
		assertTrue("Fishyy".matches(regex));
		assertTrue("Fishyyyy".matches(regex));
		
		// X{n} => X appears exactly n times
		regex = "Fishy{2}";
		assertFalse("Fish".matches(regex));
		assertFalse("Fishy".matches(regex));
		assertTrue("Fishyy".matches(regex));
		assertFalse("Fishyyyy".matches(regex));
		
		// X{n,} => X appears atleast n times
		regex = "Fishy{2,}";
		assertFalse("Fish".matches(regex));
		assertFalse("Fishy".matches(regex));
		assertTrue("Fishyy".matches(regex));
		assertTrue("Fishyyyy".matches(regex));
		
		// X{n,m} => X appears atleast n times but more than m times
		regex = "Fishy{2,3}";
		assertFalse("Fish".matches(regex));
		assertFalse("Fishy".matches(regex));
		assertTrue("Fishyy".matches(regex));
		assertFalse("Fishyyyy".matches(regex));
		
	}
}