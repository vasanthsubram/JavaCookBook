package core.anonymous;

public class AnonymousClassImplementingInterface {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("New Thread started.");
            }
        };
        Thread thread = new Thread(r);

        System.out.println(r.getClass());
        thread.start();
    }
}
