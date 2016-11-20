package core.thread.basic;

import utils.Stopwatch;

public class ThreadGroupTest {

	static Runnable r1 = new Runnable() {
		public void run() {
				//do nothing
		}
	};
	
	
	public static void main(String args[]) throws Exception {
		ThreadGroup tg1 = new ThreadGroup("TG1");
		Stopwatch s = new Stopwatch();
		Thread t=null;
		for (int i = 0; i < 100; i++) {
			//every thread belongs to the group "TG1"
			t = new Thread(tg1,r1);
			t.start();
		}
		//wait till all the threads finishes
		while(tg1.activeCount()!=0){	
		}
		s.elapsedTimeAndSpace();
	}
	
}
