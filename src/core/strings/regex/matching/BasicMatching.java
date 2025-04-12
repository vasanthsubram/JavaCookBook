package core.strings.regex.matching;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicMatching {

	public static void main(String[] args) {
	
		//**********EXACT MATCH
		//quick - no pre-compile
		assertTrue(Pattern.matches("Gold", "Gold"));
		
			//using string instances alone - which internally uses Pattern
			assertTrue("Gold".matches("Gold"));

			//reuse the pattern  --> pre-compiled
		Pattern p=Pattern.compile("Gold");
		Matcher m =p.matcher("Gold");
		assertTrue(m.matches());

		//digits
		assertTrue("123".matches("[0-9][0-9][0-9]"));
		assertTrue("439".matches("[0-9][0-9][0-9]"));
		assertFalse("4399".matches("[0-9][0-9][0-9]"));

		//match cat or dog
		assertTrue("cat".matches("cat|dog"));
		assertTrue("dog".matches("cat|dog"));

	}

}