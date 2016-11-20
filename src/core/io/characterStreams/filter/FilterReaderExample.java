package core.io.characterStreams.filter;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


public class FilterReaderExample {
	public static void main(String args[]) throws IOException {
		String input = "abcdefghij";
		UppercaseConvertor converter = new UppercaseConvertor(new StringReader(
				input));

		int c;
		while ((c = converter.read()) != -1) {
			System.out.println((char) c);
		}
		converter.close();
	}
}

class UppercaseConvertor extends FilterReader {
	public UppercaseConvertor(Reader in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toUpperCase((char) c));
	}

	public int read(char[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i = offset; i < last; i++)
			buf[i] = Character.toUpperCase(buf[i]);
		return nread;
	}
}

