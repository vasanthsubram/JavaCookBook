package core.strings.regex.matching;

import static org.junit.Assert.assertTrue;

public class AlternationMatching {

	public static void main(String[] args) {
		//match cat or dog
		assertTrue("cat".matches("cat|dog"));
		assertTrue("dog".matches("cat|dog"));
	}
}
