package core.strings.regex.matching.examples;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatePhoneNumber {

	public static void main(String[] args) {
		// X?  => 	X, once or not at all
		String pattern = "\\d\\d\\d([,\\s-])?\\d\\d\\d\\d";
		
		String s = "1234567890";
		assertFalse(s.matches(pattern));
		
		s = "1234567";
		assertTrue(s.matches(pattern));
		
		s = "123 4567";
		assertTrue(s.matches(pattern));
		
		s = "123-4567";
		assertTrue(s.matches(pattern));
		
		s = "123,4567";
		assertTrue(s.matches(pattern));
		
	}
}
