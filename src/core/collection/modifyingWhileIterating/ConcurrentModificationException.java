package core.collection.modifyingWhileIterating;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException {
 
  public static void main(String args[]){
    ArrayList<String> animals = new ArrayList<String>();
    animals.add("Horse");
    animals.add("Lion");
    animals.add("Tiger");
 
//    for(String animalObj : animals) {
//      System.out.println(animalObj);
////      animals.add("Hyena");
//    }


    List<String> listCopy = new  ArrayList<String>(animals);

    for (String s : listCopy) {
      System.out.println(s);
      System.out.println(animals);
      animals.add("Hyena");
      animals.remove(0);
    }
  }
}