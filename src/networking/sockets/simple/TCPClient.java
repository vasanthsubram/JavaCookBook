package networking.sockets.simple;

import java.io.*;
import java.net.*;

class TCPClient {
	public static void main(String argv[]) throws Exception {
		String line;
		Socket clientSocket = new Socket("127.0.0.1", 7000);
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		line = inFromServer.readLine();
		System.out.println("FROM SERVER: " + line);
		clientSocket.close();
	}
}
