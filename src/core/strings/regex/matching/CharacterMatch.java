package core.strings.regex.matching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterMatch {

	public static void main(String[] args) {
		assertTrue("gold".matches("[gb]old"));
		assertTrue("bold".matches("[gb]old"));

		//any character
		assertTrue("fold".matches(".old"));
		
		//negation - Typing a caret after the opening square bracket will negate the character class.
		assertTrue("cold".matches("[^gb]old"));
		
		//range
		assertTrue("fold".matches("[f-h]old"));
		assertTrue("gold".matches("[f-h]old"));
		assertTrue("hold".matches("[f-h]old"));
		
		//unions
		assertTrue("fold".matches("[f-h[st]]old"));
		assertTrue("hold".matches("[f-h[st]]old"));
		assertTrue("sold".matches("[f-h[st]]old"));
		assertTrue("told".matches("[f-h[st]]old"));
		
		
	}

}
