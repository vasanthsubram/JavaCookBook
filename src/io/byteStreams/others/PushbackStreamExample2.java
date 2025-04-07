package io.byteStreams.others;

import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackStreamExample2 {

	public static void main(String[] args) throws IOException {

		PushbackInputStream in = new PushbackInputStream(System.in,4);
		in.unread(new byte[]{2, 1});
		
		byte b = (byte)in.read();
		
		in.close();
	}

}
