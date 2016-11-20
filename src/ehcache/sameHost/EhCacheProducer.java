package ehcache.sameHost;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheProducer {

	static CacheManager manager = new CacheManager("src/ehcache/sameHost/ehcache.xml");

	public static void main(String[] args) throws Exception {

		System.out.println("Producer started");
		Element element = new Element("USA", "Washington DC");
		manager.getCache("testCache").put(element);

		System.out.println(manager.getCache("testCache").get("USA"));
		System.out.println("Added element to cache ");
		System.out.println(Integer.toHexString(System.identityHashCode(element)));
	}

}
