package core.system;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;

public class ExitOutOfMemoryProcess {
	
	public static void main(String[] args) throws Exception{
		ArrayList a = new ArrayList();
		spawnCleanerThread();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			byte[] b= new byte[10000];
			a.add(b);
			//System.out.println(".");
			Thread.sleep(10);
		}
	}

	 static private void spawnCleanerThread() {
		Runnable r = new Runnable() {
			private boolean tripped = false;

			public void run() {
				for (;;) {
					MemoryUsage memUsage = ManagementFactory.getMemoryMXBean()
							.getHeapMemoryUsage();
					long max = memUsage.getMax();
					long used = memUsage.getUsed();
					System.out.println("available memory = " + (max - used));
					
					if ((max - used) < (0.20 * max)) {
						if (tripped) {
							System.out.println("available memory = "
									+ (max - used) + " , so bail out ");
							// orderely shutdown, instead of exit(0)
							System.exit(0);
						}
						tripped = true;
					} else{
						tripped=false;
					}
					try {
						Thread.sleep(10000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
	}
}
