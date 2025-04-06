package core.inner;

    //----------non-static inner class

public class Outer {
    private String msg = "Hello";

    class Inner {
        void display() {
            System.out.println(msg);  // can access private members of Outer
        }
    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        //-----Tight coupling with outer instance
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

