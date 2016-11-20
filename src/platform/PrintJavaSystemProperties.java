package platform;

import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

public class PrintJavaSystemProperties {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		TreeSet tree = new TreeSet(prop.keySet());
		Iterator<String> it = tree.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " \t\t\t " + prop.get(key));
		}
	}
}
