package core.inner;

public class Outer3 {
        void outerMethod() {
            int localVar = 10;

            class LocalInner {
                void show() {
                    System.out.println("Local var: " + localVar);
                }
            }

            LocalInner inner = new LocalInner();
            inner.show();
        }

    public static void main(String[] args) {
        new Outer3().outerMethod();
    }
}
