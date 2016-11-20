package platform;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class PrintSystemEnvironment {
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		TreeSet<String> tree = new TreeSet<String>(env.keySet());
		Iterator<String> it = tree.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + " \t\t " + env.get(key));
		}
	}

}
