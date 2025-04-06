package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {

  public static void main(String[] args){

    //normal way to access map
    Map<String, Integer> items = new HashMap<>();
    items.put("A", 10);
    items.put("B", 20);
    items.put("C", 30);
    items.put("D", 40);
    items.put("E", 50);
    items.put("F", 60);

    for (Map.Entry<String, Integer> entry : items.entrySet()) {
      System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
    }

    System.out.println("using forEach and collection_lambda.collection.lambda");
    //using forEach and collection_lambda.collection.lambda
    items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

    items.forEach((k,v)->{
      if("E".equals(k)){
        System.out.println("Hello E");
      }
    });


    //------list
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");

    list.forEach(item->System.out.println(item));

  }
}
