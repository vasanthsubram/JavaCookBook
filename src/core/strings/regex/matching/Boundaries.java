package core.strings.regex.matching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Boundaries {
	public static void main(String[] args) {
		
		//word boundaries
		Matcher m=Pattern.compile("\\bis\\b").matcher("This island is beautiful");

		while(m.find()){
			System.out.println("'is' found between " + m.start() + " and " + m.end());
		}
		System.out.println();
		
		//find the 'dogs' at the BEGINNING OF LINE
		m.usePattern(Pattern.compile("^Dogs"));
		m.reset("Dogs are people too");
		while(m.find()){
			System.out.println("Dogs is found between \n" + m.start() + " and " + m.end());
		}
		System.out.println();
		
		//find the 'dog' at the END OF LINE
		m.usePattern(Pattern.compile("dog$"));
		m.reset("Husband and dog missing ... 25 cents reward for dog");
		
		while(m.find()){
			System.out.println("dog is found between \n" + m.start() + " and " + m.end());
		}

	}

}
