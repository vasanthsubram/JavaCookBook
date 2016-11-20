package ehcache.sameHostAndSameProcess;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import static org.junit.Assert.*;

public class SimpleReplicatedCacheTestUsingThreads {
	static Thread producerThread = new Thread(new Producer());
	static CacheManager producerCacheManager = null;
	static CacheManager consumerCacheManager = null;
	static boolean CONSUMER_DONE = false;
	static Element PRODUCER_ELEMENT = null;
	static Element CONSUMER_ELEMENT = null;
	
	public static void main(String[] args) throws Exception {

		Thread consumerThread = new Thread(new Consumer());
		producerThread.setDaemon(true);
		consumerThread.setDaemon(true);

		consumerThread.start();

		consumerThread.join();

		producerCacheManager.shutdown();
		consumerCacheManager.shutdown();
		System.out.println("\n Cache manager shutdown complete");

		assertTrue(PRODUCER_ELEMENT != null);
		assertTrue(CONSUMER_ELEMENT != null);
		assertFalse(PRODUCER_ELEMENT == CONSUMER_ELEMENT);

		System.out.println("\nDone !!");
	}

	
	static class Producer implements Runnable{
		@Override
		public void run() {
			producerCacheManager = new CacheManager("src/ehcache/sameHostAndSameProcess/ehcache.xml");
			System.out.println("Producer started");
			Element element = new Element("USA", "Washington DC");
			producerCacheManager.getCache("testCache").put(element);
			PRODUCER_ELEMENT=producerCacheManager.getCache("testCache").get("USA");
		
			System.out.println("\n Producer....");
			System.out.println("Added element to Producer cache : " + PRODUCER_ELEMENT);
			while(!CONSUMER_DONE){
				
			}
		}
	}

	static class Consumer implements Runnable {
		@Override
		public void run() {
			consumerCacheManager = new CacheManager("src/ehcache/sameHostAndSameProcess/ehcache.xml");
			System.out.println("Consumer started");

			producerThread.start();
			
			while (consumerCacheManager.getCache("testCache").get("USA") == null) {
			}

			CONSUMER_ELEMENT = consumerCacheManager.getCache("testCache").get("USA");
			
			System.out.println("\n Consumer....");
			System.out.println("Retrieved element from consumer cache  : " + CONSUMER_ELEMENT);
			CONSUMER_DONE = true;
		}
	}
}
