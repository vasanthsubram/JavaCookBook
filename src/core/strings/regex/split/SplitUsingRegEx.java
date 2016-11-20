package core.strings.regex.split;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SplitUsingRegEx {

	public static void main(String[] args) {
	
		//tokenize using :
		Pattern p=Pattern.compile(":");
		for(String s: p.split("Tom:Dick:Harry")){
			System.out.println(s);
		}
		System.out.println();
		
		//tokenize using a digit
		Pattern p2=Pattern.compile("\\d+");		//  \d is predefined character for reg ex [0-9]
		for(String s: p2.split("One111Two222Three333")){
			System.out.println(s);
		}
	}
}