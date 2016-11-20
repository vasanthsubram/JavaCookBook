package advanced;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class LoadClassesFromJar {

	public static void main(String[] args) throws  Exception {

		File file = new File("C:/nb-projects/bora-bora/abc-domain/src/com/abclegal/domain");
		URL url=file.toURI().toURL();
		URL[] urls = {url};
		ClassLoader loader = new URLClassLoader(urls);
                Class aClass = loader.loadClass("java.lang.String");
		System.out.println(aClass.getName());
	}

}
