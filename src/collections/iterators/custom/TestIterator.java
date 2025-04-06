package collections.iterators.custom;

import java.util.ArrayList;


public class TestIterator {

 public static void main(String args[]) {
   ArrayList<String> animalList = new ArrayList<String>();
   animalList.add("Horse");
   animalList.add("Lion");
   animalList.add("Tiger");
   Animal animal = new Animal(animalList);
   for (String animalObj : animal) {
     System.out.println(animalObj);
   }
 }
}