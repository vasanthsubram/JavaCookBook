package oo.protected2;

import oo.protectedtest.SubOne;
import oo.protectedtest.Super;

public class SubTwo extends Super {

	public static void main(String[] args) {
		Super s = new Super();
		SubOne s1 = new SubOne();

		SubTwo s2 = new SubTwo();

		// s.say (" Super ") ; // compile error
		// From within SubTwo, the protected members of Super cannot be accessed

		// s1.say ("SubOne") ; // compile error
		// From within SubTwo, the protected members of SubOne cannot be
		// accessed

		s2.say("SubTwo");

	}
}
