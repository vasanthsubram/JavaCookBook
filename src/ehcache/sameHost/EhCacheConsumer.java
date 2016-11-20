package ehcache.sameHost;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheConsumer {

	static CacheManager manager = new CacheManager("src/ehcache/sameHost/ehcache.xml");

	public static void main(String[] args) throws Exception {
		System.out.println("Consumer started");
		for(;;){
			if(manager.getCache("testCache").get("USA") != null){
				Element element = manager.getCache("testCache").get("USA");
				System.out.println(element);
				
				System.out.println(Integer.toHexString(System.identityHashCode(element)));
				break;
			}
		}
		
	}

}
