package core.strings.regex.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicReplacement {
	public static void main(String[] args) {
		
		Pattern p=Pattern.compile("Gold");
		//Matcher m =p.matcher("Gold");
		Matcher m=p.matcher("You may have a heart of Gold; so does a hard-boiled egg");
		System.out.println(m.replaceAll("Yellow"));
	}

}
