package core.collection.apacheCollectionUtils.predicates;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * Demonstating smalltalk like enumeration in Java using apache CollectionUtils
 *
 * Create a predicate using PredicateUtils.
 * The class being searched must implements certain methods like equals() if equalPredicate is used
 * @author vsubramanian
 */
public class PredicatesDemo {

     private static class Person{
        String name;

        Person(String name){
            this.name=name;
        }
        public boolean equals(Object other){
             return name.equals(((Person) other).name);
        }
    }
     
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("A"), new Person("B"),new Person("C"),new Person("D"));

        Collection<Person> result = CollectionUtils.select(persons, new Predicate(){
            public boolean evaluate(Object o){
                return ((Person)o).name.equals("B");
            }
        });

        for(Person p: result){
             System.out.println(p.name);
        } 
    }
}
