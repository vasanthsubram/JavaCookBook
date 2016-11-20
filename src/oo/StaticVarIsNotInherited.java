package oo;

/**
 *
 * @author vsubramanian
 */
public class StaticVarIsNotInherited {

    public static void main(String[] args) {

            A a = new A();
            B b = new B();
            a.x=10;
            System.out.println(b.x);

            b.x=20;
            System.out.println(a.x);
    }
}


class A{
    static int x;
}
class B extends A{
}