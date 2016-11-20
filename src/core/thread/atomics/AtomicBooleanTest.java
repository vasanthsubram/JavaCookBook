package core.thread.atomics;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	public static AtomicBoolean aBoolean = new AtomicBoolean(false);
	public static void main(String[] args) throws Exception {

		
			Runnable r1 = new Runnable() {
				public void run(){
					long id=Thread.currentThread().getId();
					System.out.println("Inital value =  " + id + "  " + aBoolean);
					aBoolean.compareAndSet(false, true);
					System.out.println("Final value =  " + id + "  " + aBoolean);
				}
			};
			
			Runnable r2 = new Runnable() {
				public void run(){
					long id=Thread.currentThread().getId();
					System.out.println("Inital value =  " + id + "  " + aBoolean);
					aBoolean.compareAndSet(true, false);
					System.out.println("Final value =  " + id + "  " + aBoolean);
				}
			};
			
			for(int i=0;i<1;i++){
				new Thread(r1).start();
				new Thread(r2).start();
			}
			
			Thread.currentThread().sleep(5000);
			

	}

}
