package networking;

import java.net.Socket;

public class IPAddressFromMachineName {
	public static void main(String[] args) {

		try {
			String host = "localhost";
			Socket s = new Socket(host, 30000);
			System.out.println("IP for " + host + "  is  "
					+ s.getInetAddress().getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
