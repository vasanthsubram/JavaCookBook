package core.collection.apacheCollectionUtils.predicates;

import java.lang.reflect.Field;
import org.apache.commons.collections.Predicate;

public class NamePredicate {

    
    public static Predicate contains(final String name){
           return new Predicate() {
                @Override
                public boolean evaluate(final Object object) {
                    try {
                        Field f = object.getClass().getDeclaredField("name");
                        return ((String) f.get(object)).contains(name);
                    } catch (Exception e) {
                    }
                    return false;
                }
            };
    }
}
