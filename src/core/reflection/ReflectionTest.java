package core.reflection;

import java.lang.reflect.*;

public class ReflectionTest {

    public static void main(String args[]) throws Exception {
            Class c = Class.forName("java.lang.Object");

            Method m[] = c.getDeclaredMethods();
            if (c.getMethod("getClass", null) != null) {
                System.out.println(c.getName()
                        + "  understands getClass method");
            }

            for (Method aMethod : m) {
                System.out.println(aMethod.getName());

                // invoke getClass() on a string object
                if (aMethod.getName().equals("getClass")) {
                    System.out.println(aMethod.invoke("HELLO", new Object[]{}));
                }
            }
    }
}
