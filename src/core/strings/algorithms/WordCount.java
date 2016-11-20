package core.strings.algorithms;

import java.util.StringTokenizer;

public class WordCount {

	public static void main(String[] args) {
		int count = 0;
		String input= "Hello,World";
		int size = input.length();
		char ch;
		boolean inWord = false;

		//one way
		StringTokenizer strTok = new StringTokenizer(input);
		System.out.println(strTok.countTokens());
		
		//another way - smart about the commas
		for (int i = 0; i < size; i++) {
			ch = input.charAt(i);
			if (ch == ' ' || ch == '\t' || ch==',') {
				inWord = false;
			} else {
				if (!inWord) {
					inWord = true;
					count++;
				}
			}
		}
		System.out.println("No of words = " + count);

	}

}
