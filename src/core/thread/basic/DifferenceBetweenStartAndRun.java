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
	}
}
