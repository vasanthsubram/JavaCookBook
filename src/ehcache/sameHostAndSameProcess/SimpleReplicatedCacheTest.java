package ehcache.sameHostAndSameProcess;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import static org.junit.Assert.*;

public class SimpleReplicatedCacheTest {

	public static void main(String[] args) throws Exception {

		CacheManager producerCacheManager = new CacheManager(
				"src/ehcache/sameHostAndSameProcess/ehcache.xml");
		CacheManager consumerCacheManager = new CacheManager(
				"src/ehcache/sameHostAndSameProcess/ehcache.xml");

		Element PRODUCER_ELEMENT = null;
		Element CONSUMER_ELEMENT = null;

		Element element = new Element("USA", "Washington DC");
		producerCacheManager.getCache("testCache").put(element);
		
		PRODUCER_ELEMENT = producerCacheManager.getCache("testCache")
				.get("USA");

		System.out.println("Added element to Producer cache : "
				+ PRODUCER_ELEMENT);

		Thread.sleep(2000);
		CONSUMER_ELEMENT = consumerCacheManager.getCache("testCache")
				.get("USA");

		System.out.println("Retrieved element from consumer cache  : "
				+ CONSUMER_ELEMENT);

		producerCacheManager.shutdown();
		consumerCacheManager.shutdown();

		assertTrue(PRODUCER_ELEMENT != null);
		assertTrue(CONSUMER_ELEMENT != null);
		assertFalse(PRODUCER_ELEMENT == CONSUMER_ELEMENT);
		
		System.out.println("\nDone !!");
	}
}
