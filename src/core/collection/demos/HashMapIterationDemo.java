package core.collection.demos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterationDemo {

  public static void main(String[] args){
    Map<String,String> map = new HashMap<String,String>(2);
    //in this it allocates 8

    map.put("USA", "Washington DC");
    map.put("India", "New Delhi");
    map.put("England", "London");

    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
    }

    for(String k: map.keySet()){
      System.out.println(k);
    }

    for(String v: map.values()){
      System.out.println();
    }

    //using forEach and lambda
    map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

    map.forEach((k,v)->{
      if("E".equals(k)){
        System.out.println("Hello E");
      }
    });


    Iterator<String> it = map.keySet().iterator();
    while (it.hasNext()) {
      String s = it.next();
      //key could be null
      if (s != null) {
        if (s.equals("Heaven") | (s.equals("Hell"))) {
          //while iterating through iterator, remove using the iterator
          //in this case the set returned by keySet() is backed by the map
          //therefore removing through the iterator deletes the key-value pair in the map
          it.remove();
        }
      }
    }

  }
}
