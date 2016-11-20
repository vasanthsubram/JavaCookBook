package ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhCache2 {

	static CacheManager manager1 = new CacheManager("src/ehcache/test-ehcache.xml");
	
	public static void main(String[] args) throws Exception {
		
		
//		CacheManager manager2 = new CacheManager("src/ehcache/test-ehcache.xml");
		Runnable t1 = new Runnable(){
			public void run(){
				System.out.println("Thread 1 started");
				Element element1 = new Element("USA", "Washington DC");
				manager1.getCache("testCache").put(element1);
				
				System.out.println(manager1.getCache("testCache").get("USA"));
				System.out.println("Added element to cache 1");
			}
			
		};
		
		Runnable t2 = new Runnable(){
			public void run(){
				System.out.println("Thread 2 started");
				for(int i=0;i<1000;i++){
					if(manager1.getCache("testCache2").get("USA") != null){
					System.out.println(manager1.getCache("testCache2").get("USA"));
					}
				}
				System.out.println("Thread 2 done");
			}
		};
		
		Thread t = new Thread(t1);
		t.start();
		t.join();
		
		new Thread(t2).start();
		
//		System.out.println(manager2.getCache("testCache").get("USA"));
	}

}
