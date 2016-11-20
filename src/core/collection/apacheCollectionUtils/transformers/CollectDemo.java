package core.collection.apacheCollectionUtils.transformers;

import java.util.Collection;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.TransformerUtils;
import core.collection.apacheCollectionUtils.closures.PrintIt;
import java.util.Arrays;
import java.util.List;

public class CollectDemo {  
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("A"), new Person("B"), new Person("C"), new Person("D"));

        Collection<String> names = CollectionUtils.collect(persons, TransformerUtils.invokerTransformer("getName"));
        CollectionUtils.forAllDo(names, PrintIt.getInstance());
    }

     static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
}
