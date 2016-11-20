package core.collection.apacheCollectionUtils.closures;

import org.apache.commons.collections.Closure;

/**
 *
 * @author vsubramanian
 */
public class PrintIt implements Closure {

    private static PrintIt singleton = new PrintIt();

    public static PrintIt getInstance() {
        return singleton;
    }

    private PrintIt() {
    }

    public void execute(Object o) {
        if (o == null) {
            System.out.println("null");
        } else {
            System.out.println(o.toString());
        }
    }
}

