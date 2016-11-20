package core.system;

/**
 *
 * @author vsubramanian
 */
public class ObjectImplementInterface {

    public static void main(String[] args) {
        //string implements Comparable interface
        System.out.println(Comparable.class.isAssignableFrom("Hello".getClass()));
        System.out.println("Hello" instanceof Comparable);
        System.out.println(Comparable.class.isInstance("Hello"));


        System.out.println(Object.class.isAssignableFrom("Hello".getClass()));
        System.out.println("Hello" instanceof Object);
        System.out.println(Object.class.isInstance("Hello"));
    }
}
