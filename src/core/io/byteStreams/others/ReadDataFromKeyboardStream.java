package core.io.byteStreams.others;

import java.io.BufferedInputStream;

public class ReadDataFromKeyboardStream {

	public static void main(String[] args) {

		int input;
		StringBuilder b = new StringBuilder();

		System.out.println("Enter data; To quit enter ctrl-z; \n Your data will be printed after you quit");
		System.out.println("----------------------------------------------------------------");
		BufferedInputStream in = new BufferedInputStream(System.in);
		try {
			while ((input = in.read()) != -1) {
				b.append((char) input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(b.toString());
	}

}
