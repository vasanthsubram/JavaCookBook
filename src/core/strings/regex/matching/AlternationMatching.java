package core.strings.regex.matching;

import static org.junit.Assert.assertTrue;

public class AlternationMatching {

	public static void main(String[] args) {
		//match cat or dog
		assertTrue("cat".matches("cat|dog"));
		assertTrue("dog".matches("cat|dog"));

//		assertTrue("MDP.TRAVELOCITY-ZA.META.HPA.CORESEARCH-LOCALUNIVERSAL.HOTEL".matches("/.*\\.TRAVELOCITY-([a-zA-Z]{2})\\.META\\.HPA\\..*/i"));

		assertTrue("MDP.TRAVELOCITY-ZA.META.HPA".matches("/[a-zA-Z]{3[]}\\.TRAVELOCITY-[a-zA-Z]{2}\\.META\\.HPA/i"));

	}
}
