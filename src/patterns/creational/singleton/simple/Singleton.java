package patterns.creational.singleton.simple;

public class Singleton {

//	private static final Singleton _instance = new Singleton();

	//lazy init
	private static volatile Singleton _instance;

	// Private constructor prevents instantiation from other classes
	private Singleton() {
	}

//	public static Singleton getInstance() {
//		return _instance;
//	}

	//lazy init
	public static Singleton getInstance(){
	   if(_instance == null){
	            synchronized(Singleton.class){
	              if(_instance == null)
	              _instance = new Singleton();
	            }
	   }
	   return _instance;
	}
	
}

