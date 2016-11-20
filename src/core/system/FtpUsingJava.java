package core.system;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FtpUsingJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL(
			"ftp://transit:startup1@qa3.chq.ei//README;type=i");
			
			URLConnection con = url.openConnection();
			BufferedInputStream in = new BufferedInputStream(con
					.getInputStream());
			FileOutputStream out = new FileOutputStream("C:\\file.txt");

			int i = 0;
			byte[] bytesIn = new byte[1024];
			while ((i = in.read(bytesIn)) >= 0) {
				out.write(bytesIn, 0, i);
			}
			out.close();
			in.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
