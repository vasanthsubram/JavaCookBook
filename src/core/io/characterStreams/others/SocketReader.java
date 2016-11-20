package core.io.characterStreams.others;

import java.io.*;
import java.net.*;

public class SocketReader {
	public static void main(String[] args) throws IOException {
		Socket inSocket = null;
		InputStream in = null;
		try {
			inSocket = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			in = inSocket.getInputStream();
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (inSocket != null) {
				inSocket.close();
			}
		}
	}
}

