package networking.sockets.simple.echoServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.System;

/**
 * Demonstrate sockets.
 * This program receives a string from client and displays it.
 * @author chq-vasanthakumars
 *
 */
public class Server {
	public static void main(String args[]) throws IOException {
		ServerSocket s = new ServerSocket(2000);
		Socket sock;
		BufferedReader datain;

		System.out.println("Server starting ...");
		while ((sock=s.accept()) != null) {
			
			datain = new BufferedReader(new InputStreamReader(sock
					.getInputStream()));
			System.out.println("Receiving....");
			System.out.println(datain.readLine());
			sock.close();
		}
		s.close();
	}
}

