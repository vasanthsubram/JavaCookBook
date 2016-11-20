package networking.sockets.simple.echoServer;

import java.net.Socket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.lang.System;

/**
 * Demonstrate sockets.
 * This program sends a string to server which displays it.
 * @author chq-vasanthakumars
 *
 */
public class Client {
	public static void main(String args[]) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Type your text and hit enter. To quit hit ctrl-z ");
		while (true) {
			line = in.readLine();
			if (line == null) {
				System.out.println("\n\nExiting");
				break;
			}
			System.out.println("Sending..." + line);

			Socket socket = new Socket(InetAddress.getLocalHost(), 2000);
			BufferedWriter dataout;
			dataout = new BufferedWriter(new OutputStreamWriter(socket
					.getOutputStream()));
			dataout.write(line);
			dataout.flush();
			socket.close();
		}
	}
}
