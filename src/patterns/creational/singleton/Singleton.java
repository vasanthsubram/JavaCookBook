package patterns.creational.singleton;

import static org.junit.Assert.assertTrue;

/**
 * Simple way to create Singleton
 * Create the lone instance when the class loads
 */
public class Singleton {

	private static final Singleton _instance = new Singleton();

	// Private constructor prevents instantiation from other classes
	private Singleton() {}

	public static Singleton getInstance(){
	   return _instance;
	}

	public static void main(String[] args) {
		assertTrue(Singleton.getInstance()==Singleton.getInstance());
	}
}

