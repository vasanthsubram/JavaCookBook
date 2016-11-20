package core.io.javaIOFile;

import java.io.File;
import java.io.IOException;

public class PrintCurrentDirectory {
	public static void main(String args[]) {
		String dir = "user.dir"; // set to current directory
                System.out.println(System.getProperty(dir));
		try {
			dir = new File(System.getProperty(dir)).getCanonicalPath();
		} catch (IOException e1) { /* handler required but null */
		}
		System.out.println("Current dir : " + dir);
	}
}
