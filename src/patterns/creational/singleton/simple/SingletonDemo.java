package patterns.creational.singleton.simple;

import static org.junit.Assert.assertTrue;

public class SingletonDemo {

	public static void main(String[] args) {
		assertTrue(Singleton.getInstance()==Singleton.getInstance());
	}
}
