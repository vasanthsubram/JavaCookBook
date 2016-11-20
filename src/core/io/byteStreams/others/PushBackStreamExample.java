package core.io.byteStreams.others;

import java.io.*;

public class PushBackStreamExample {
	public static void main(String[] args) throws IOException {
		PushbackInputStream in = new PushbackInputStream(System.in);
		// longest sequence found
		int maxLen = 0;
		// the byte in that sequence
		int byteMaxLen = -1;
		// current byte in input
		int currByte;

		System.out.println("Enter a string and when done hit enter and then ctrl-z ");
		System.out.println();
		do {
			int cnt;
			// 1st byte in sequence
			int currMatch = in.read();
			for (cnt = 1; (currByte = in.read()) == currMatch; cnt++)
				continue;
			if (cnt > maxLen) {
				// remember length
				maxLen = cnt;
				// remember which byte value
				byteMaxLen = currMatch; // 
			}
			// pushback start of next seq
			in.unread(currByte);
		} while (currByte != -1);

		System.out.println(maxLen + " bytes of " + byteMaxLen + " ("
				+ (char) byteMaxLen + ")");
	}
}
