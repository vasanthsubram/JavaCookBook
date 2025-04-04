package core.thread.basic;

// This example shows how to spawn a thread and wait till the child thread finishes.
public class ThreadJoin {
	public static void main(String args[]) {
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("\t Inside the child thread - Start.");
				try {
					Thread.currentThread().sleep(1000);
				} catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("\t Inside the child thread - End");
			}
		};
		Thread t = new Thread(r1);

		try {
			System.out.println("Main thread - Waiting for the child thread to finish");
			t.start();
			
			// the main thread will till 't' finishes
			t.join();
			System.out.println("Main thread -  child thread is Done");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
