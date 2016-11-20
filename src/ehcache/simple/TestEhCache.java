package ehcache.simple;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class TestEhCache {

	public static void main(String[] args) {

		CacheManager manager = new CacheManager("src/ehcache/simple/ehcache.xml");
		
		String[] cacheNames = manager.getCacheNames();
		
		if(cacheNames.length==0){
			System.out.println("No cache");
		}
		for(String s: cacheNames){
			System.out.println(s);
		}
		
		Element element1 = new Element("USA", "Washington DC");
		Element element2 = new Element("France", "Paris");
		
		Cache cache = manager.getCache("testCache");
		
		cache.put(element1);
		cache.put(element2);
		
		System.out.println(cache.get("USA"));
		System.out.println(cache.get("USA").getValue());
		
		cache.remove("USA");
		System.out.println(cache.get("USA"));
		
		System.out.println(cache.isExpired(element1));
	}

}
