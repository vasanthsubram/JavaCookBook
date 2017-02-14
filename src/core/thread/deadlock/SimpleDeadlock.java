package core.thread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * This class creates a dead lock
 * @author chq-vasanthakumars
 *
 */
public class SimpleDeadlock {

	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	static void putToSleep(Thread t){
		try{
			t.sleep(100);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static Thread  t1 = new Thread(){
		public void run(){
			synchronized(lock1){
				System.out.println("Thread 1 has lock 1 and going to get lock2");
				putToSleep(this);
				synchronized (lock2) {
					System.out.println("Thread 1 has both locks");
				}
			}
		}
	};
	
	static Thread t2 = new Thread(){
		public void run(){
			synchronized(lock2){
				System.out.println("Thread 2 has lock 2 and going to get lock1");
				putToSleep(this);
				synchronized (lock1) {
					System.out.println("Thread 2 has both locks");
				}
			}
		}
	};
	
		public static void main(String args[]) throws Exception{
			t1.start();
			t2.start();
			Thread.currentThread().sleep(2000);
			System.out.println();
			
			 ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
			  long[] ids = tmx.findMonitorDeadlockedThreads();
			  if (ids != null) {
			     ThreadInfo[] infos = tmx.getThreadInfo(ids, 0);
			     System.out.println("The following threads are deadlocked:");
			     for (ThreadInfo ti : infos) {
			        System.out.println(ti);
			     }
			  }
		}
}
