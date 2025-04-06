package core.thread.atomics;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {

	public static AtomicBoolean aBoolean = new AtomicBoolean(false);
	public static void main(String[] args) throws Exception {

		
			Runnable r1 =  () -> {
					long id=Thread.currentThread().getId();
					System.out.println("Thread id =  " + id + " Before compare = " + aBoolean);
					aBoolean.compareAndSet(false, true);
					System.out.println("Thread id =  " + id + " After compare = " + aBoolean);
			};
			
			Runnable r2 = () -> {
					long id=Thread.currentThread().getId();
					System.out.println("Thread id =  " + id + " Before compare = " + aBoolean);
					aBoolean.compareAndSet(true, false);
					System.out.println("Thread id =  " + id + " After compare = " + aBoolean);
			};
			
			for(int i=0;i<1;i++){
				new Thread(r1).start();
				new Thread(r2).start();
			}
			
			Thread.currentThread().sleep(5000);
			

	}

}
