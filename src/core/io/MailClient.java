package core.io;

import java.net.*;
import java.io.*;

public class MailClient {

	public static void main(String[] args) {

		String id = "vasanthakumar.subramanian@gmail.com";

		try {
			URL u = new URL("mailto:" + id);
			URLConnection uc = u.openConnection();
			uc.setDoOutput(true);
			//uc.connect();
			OutputStream out = uc.getOutputStream();
			for (int c = System.in.read(); c != -1; c = System.in.read()) {
				out.write(c);
			}
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
