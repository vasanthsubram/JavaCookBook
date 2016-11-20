package core.collection;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	static ConcurrentHashMap<String, ConcurrentHashMap<Long, String>> map;
	static int MAX = 10000000;

	public static void main(String[] args) throws Throwable {

		printMemoryStat();
		
		map = new ConcurrentHashMap<String, ConcurrentHashMap<Long, String>>();
		map.put("TransactionProcessor", new ConcurrentHashMap<Long, String>());

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < MAX; i++) {
					map.get("TransactionProcessor").put(
							Thread.currentThread().getId(), "Hello t1 " + i);
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < MAX; i++) {
					map.get("TransactionProcessor").put(
							Thread.currentThread().getId(), "Hello t2 " + i);
				}
			}
		};

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map);
		System.out.println("Size = " + map.get("TransactionProcessor").size());
		
		printMemoryStat();
		System.out.println("Forcing GC");
		System.gc();
		Thread.sleep(5000);
		printMemoryStat();
	}
	
	static void printMemoryStat() {
		MemoryUsage memUsage = ManagementFactory.getMemoryMXBean()
				.getHeapMemoryUsage();
		long max = memUsage.getMax();
		long used = memUsage.getUsed();
		System.out.println("max memory = " + max);
		System.out.println("used memory = " + used);
		System.out.println("available memory = " + (max - used));
	}

}
