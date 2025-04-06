package core.inner;

//----------static inner class

class Outer2 {
    static String msg = "Hello static inner class";

    static class StaticNested {
        //It cannot access non-static members of the outer class directly.
        void display() {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Outer2.StaticNested nested = new Outer2.StaticNested();
        nested.display();
    }
}