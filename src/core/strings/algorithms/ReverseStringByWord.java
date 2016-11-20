package core.strings.algorithms;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseStringByWord {

	public static void main(String[] args) {

		String test = "Reverse. this   ,string";
		Stack<String>  stack = new Stack<String>();
		StringTokenizer strTok = new StringTokenizer(test);

		while(strTok.hasMoreTokens()) {
		    stack.push((String) strTok.nextElement());
		}
		StringBuffer revStr = new StringBuffer();
		while(!stack.empty()) {
		    revStr.append(stack.pop());
		    revStr.append(" ");
		}
		System.out.println("Original string: " + test);
		System.out.println("\nReversed string: " + revStr);
		
	

	}

}
