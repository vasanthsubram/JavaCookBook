package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1, 2, 3);

    //forEach accepts a Consumer
    list.forEach(System.out::println);

    //reference to a static method
    Function<String, Double> doubleConvertor=Double::parseDouble;
    System.out.println("using method reference - "+ doubleConvertor.apply("0.254"));

    Function<String, Double> doubleConvertorLambda=(String s) -> Double.parseDouble(s);
    System.out.println("using Lambda - "+ doubleConvertorLambda.apply("0.254"));


    //Reference to an instance method of an object
    Consumer<String> stringPrinter=System.out::println;
    stringPrinter.accept("Print from method reference based instance");

    Consumer<String> stringPrinterLambda=(String s) -> System.out.println(s);
    stringPrinterLambda.accept("Print from instance created from Lambda");


    //Reference to an instance method of an arbitrary object of a particular type
    List<Integer> intList=Arrays.asList(1,2,3,4);
    BiPredicate<List<Integer>,Integer> isPartOf=List::contains;
    System.out.println("Is 1 a part of the intList - "+ isPartOf.test(intList, 1));

    BiPredicate<List<Integer>,Integer> isPartOfLambda=(List<Integer> listInt, Integer value) -> listInt.contains(value);
    System.out.println("Is 1 a part of the intList - "+ isPartOfLambda.test(intList, 1));


    //constructor
    List<Person> people = Person.getPersons();
    Set<String> set =
          people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));

    System.out.println(set);
  }


  static class Person{
    String name;
    Person(String name){
      this.name=name;
    }
    public String getName(){
      return name;
    }

    static List<Person> getPersons(){
      return Arrays.asList(new Person("John"), new Person("Jake"), new Person("Emily"));
    }
  }
}
