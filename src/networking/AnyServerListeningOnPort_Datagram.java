package networking;

import java.net.DatagramSocket;
import java.net.SocketException;

public class AnyServerListeningOnPort_Datagram {

	public static void main(String[] args) {

		DatagramSocket theServer;

		for (int i = 501; i <= 1024; i++) {
			try {
				theServer = new DatagramSocket(i);
				theServer.close();
			} catch (SocketException e) {
				System.out.println("There is a server on port " + i + ".");
			} 
		} 
		System.out.println("Done");
	}

}
