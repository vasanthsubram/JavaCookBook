package core.system;

import java.net.URL;
import java.net.URLClassLoader;

public class PrintClasspath {
	public static void main(String[] args) {
		String arr[] = (System.getProperty("java.class.path")).split(";");
		for (String s : arr) {
			System.out.println(s);
		}

		System.out.println("\n USing the class loader");
		// Get the System Classloader
		ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
		// Get the URLs
		URL[] urls = ((URLClassLoader) sysClassLoader).getURLs();
               
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].getFile());
		}
	}
}