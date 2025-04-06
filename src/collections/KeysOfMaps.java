package collections;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class KeysOfMaps {

	public static void main(String[] args) {
		//wrappers are unique objects even though the values are same
		IdentityHashMap<Long, String> identityMap = new IdentityHashMap<Long, String>();
		identityMap.put(new Long(2), "hello");
		identityMap.put(new Long(2), "hello");
		System.out.println(identityMap);
		
		Map<Long,String> map = new HashMap<Long,String>();
		map.put(new Long(2), "hello");
		map.put(new Long(2), "hello");
		System.out.println(map);
	}

}
