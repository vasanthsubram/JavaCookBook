package patterns.creational.singleton;


import static org.junit.Assert.assertTrue;

/**
 * Create singleton with lazy init
 *
 * Created by vasanth on 12/13/16.
 */
public class Singleton2 {

    //lazy init
    private static volatile Singleton2 _instance;

    // Private constructor prevents instantiation from other classes
    private Singleton2() {}

    //lazy init
    public static Singleton2 getInstance(){
        if(_instance == null){
            synchronized(Singleton.class){
                if(_instance == null)
                    _instance = new Singleton2();
            }
        }
        return _instance;
    }

    public static void main(String[] args) {
        assertTrue(Singleton.getInstance()==Singleton.getInstance());
    }
}

