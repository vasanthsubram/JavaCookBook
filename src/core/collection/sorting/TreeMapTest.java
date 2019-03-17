package core.collection.sorting;

import java.util.Map;
import java.util.TreeMap;

/**
 *  Iterate a map in order or reverse order
 */
public class TreeMapTest {
  public static void main(String[] args){

    Map<Integer, String> map = new TreeMap<>();
//    Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
    map.put(2, "b");
    map.put(1, "a");
    map.put(3, "c");
    map.put(27, "z");
    map.put(4, "d");

    for(Map.Entry<Integer, String> entry: map.entrySet()){
      System.out.println(entry.getKey() + " " + entry.getValue());
    }

    for(int key:map.keySet()){
      System.out.println(key + " " + map.get(key));
    }

    for(String val:map.values()){
      System.out.println(val);
    }
  }
}
