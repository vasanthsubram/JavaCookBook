package core.strings.regex.matching;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
	}
}