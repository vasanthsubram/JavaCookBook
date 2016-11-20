package core.collection.apacheCollectionUtils.predicates;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

/**
 * Demonstating smalltalk like enumeration in Java using apache CollectionUtils
 *
 * Create a predicate using PredicateUtils.
 * The class being searched must implements certain methods like equals() if equalPredicate is used
 * @author vsubramanian
 */
public class PredicatesDemoSimple {

    public static void main(String[] args) {
        List<String> strings=Arrays.asList("Gold", "Silver", "Copper");

        Collection<String> result = CollectionUtils.select(strings, PredicateUtils.equalPredicate("Copper"));

        System.out.println(result.size());
        System.out.println(result.toArray()[0].toString());
        
    }
}
