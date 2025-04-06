package collection_lambda.collection.modifyingWhileIterating;

import java.util.ArrayList;
 
public class ConcurrentModificationException {
 
  public static void main(String args[]){
    ArrayList<String> animal = new ArrayList<String>();
    animal.add("Horse");
    animal.add("Lion");
    animal.add("Tiger");
 
    for(String animalObj : animal) {
      System.out.println(animalObj);
      animal.add("Hyena");
    }
  }
}