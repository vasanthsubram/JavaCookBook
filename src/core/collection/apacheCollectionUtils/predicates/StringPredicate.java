package core.collection.apacheCollectionUtils.predicates;

import java.lang.reflect.Method;
import org.apache.commons.collections.Predicate;

public class StringPredicate {

    public static Predicate contains(final String methodName, final String value) {
        return new Predicate() {

            @Override
            public boolean evaluate(final Object object) {
                try {
                    Method m = object.getClass().getDeclaredMethod(methodName);
                    return ((String) m.invoke(object)).contains(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        };
    }
}
