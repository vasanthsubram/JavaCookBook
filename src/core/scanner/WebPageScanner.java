package core.scanner;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.Scanner;

public class WebPageScanner {

	public static void main(String[] args) {
		try {
			URLConnection connection = new URL("http://www.expeditors.com")
					.openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			while(scanner.hasNext()){
				System.out.println(scanner.next());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
