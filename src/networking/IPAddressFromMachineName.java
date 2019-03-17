package networking;

import java.net.InetAddress;
import java.net.Socket;

public class IPAddressFromMachineName {
	public static void main(String[] args) {

		try {
			String host = "localhost";
			Socket s = new Socket(host, 8443);
			System.out.println("IP for " + host + "  is  " + s.getInetAddress().getHostAddress());
			System.out.println("canonical host name for " + host + "  is  " + s.getInetAddress().getCanonicalHostName());
			System.out.println("hostname for " + host + "  is  " + s.getInetAddress().getHostName());
			System.out.println("address for " + host + "  is  " + s.getInetAddress().getAddress());


			byte[] ipAddr = new byte[] { 127, 0, 0, 1 };
			InetAddress addr = InetAddress.getByAddress(ipAddr);
			String hostnameCanonical = addr.getCanonicalHostName();
			System.out.println(hostnameCanonical);
			System.out.println(addr.getAddress());
			System.out.println(addr.getHostAddress());
			System.out.println(addr.getHostName());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
