package core.thread.basic;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        Thread vThread = Thread.startVirtualThread(() -> {
            int localVar = 100;  // Stored in the stack
            String msg = "Hello, Virtual Threads!"; // Stored in the heap

            System.out.println(msg + " Local Variable: " + localVar);
        });

        try {
            vThread.join();  // Wait for the virtual thread to finish execution
            //This ensures that the main thread waits for the virtual thread to finish before the program exits.
            // Without join(), the main thread could exit before the virtual thread has a chance to print anything.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}