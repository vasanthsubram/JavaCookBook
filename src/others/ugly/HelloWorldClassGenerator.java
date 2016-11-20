package others.ugly;

import java.util.Formatter;


public class HelloWorldClassGenerator {
	public static void main(String[] args) {
		String s ="public class HelloWorld{ public static void main(String args[]){ System.out.println(\"HELLO WORLD\");}}";
		StringBuilder builder = new StringBuilder();
		//String s1="\\u00";
		Formatter f = new Formatter(builder);
		for(char c: s.toCharArray()){
//			buf.append(s1);
//			buf.append(Integer.toHexString(c));
			//buf.append(String.format("\\u00%4H", c));
			f.format("\\u%04x", (int)c);
		}
		System.out.println(builder.toString());
	}
}

/*
 * The String below is the result of running the program and can be put in a class named HelloWorld and be run
	
\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0063\u006c\u0061\u0073\u0073\u0020\u0048\u0065\u006c\u006c\u006f\u0057\u006f\u0072\u006c\u0064\u007b\u0020\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0073\u0074\u0061\u0074\u0069\u0063\u0020\u0076\u006f\u0069\u0064\u0020\u006d\u0061\u0069\u006e\u0028\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0061\u0072\u0067\u0073\u005b\u005d\u0029\u007b\u0020\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u006f\u0075\u0074\u002e\u0070\u0072\u0069\u006e\u0074\u006c\u006e\u0028\u0022\u0048\u0045\u004c\u004c\u004f\u0020\u0057\u004f\u0052\u004c\u0044\u0022\u0029\u003b\u007d\u007d

*/