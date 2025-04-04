package core.thread.basic;

public class DifferenceBetweenStartAndRun {

	public static void main(String[] args) {
		
		System.out.println("Parent Thread id = " + Thread.currentThread().getId());
		
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("Runnable Thread id = " + Thread.currentThread().getId());
			}
		};
		
		Thread t = new Thread(r);
		
		//invoking run directly does not create a new thread
		t.run();
		
		t.start();
		//When you create an OS thread and call start(), the OS schedules the thread to run concurrently with the main thread.
		// The main thread will not exit immediately, as the OS will handle the scheduling and the lifetime of the thread.
		// The main thread waits for the OS thread to complete unless explicitly interrupted or when the program finishes.
		//there is no need for thead.join()
	}
}
