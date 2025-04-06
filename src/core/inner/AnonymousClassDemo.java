package core.inner;

//-----------------anonymous class

public class AnonymousClassDemo {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running anonymously");
            }
        };

        new Thread(r).start();
    }
}
