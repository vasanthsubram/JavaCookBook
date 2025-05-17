package core.thread.basic;

//A thread is always an instance of Thread class
public class BasicThreadCreation {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                System.out.println("Hello World");
            }
        };
        t.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Bye World");
            }
        });
        t2.start();
    }
}
