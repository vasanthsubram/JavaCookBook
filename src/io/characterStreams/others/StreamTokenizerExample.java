package io.characterStreams.others;

import java.io.CharArrayReader;
import java.io.StreamTokenizer;

public class StreamTokenizerExample {

	public static void main(String[] args) throws Exception {

		String input = "1234#abcd#5678#efgh*91011?werwer@345345!sdfsf^888&pppp";

		StreamTokenizer tokenizer = new StreamTokenizer(new CharArrayReader(
				input.toCharArray()));
		int tok_type;
		while ((tok_type = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
			if (tok_type == StreamTokenizer.TT_NUMBER) {
				System.out.println((int) tokenizer.nval);
			}
			if (tok_type == StreamTokenizer.TT_WORD) {
				System.out.println(tokenizer.sval);
			}
		}
	}
}
