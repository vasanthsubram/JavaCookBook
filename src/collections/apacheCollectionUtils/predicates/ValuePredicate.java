package collections.apacheCollectionUtils.predicates;

import java.lang.reflect.Method;
import org.apache.commons.collections.Predicate;

public class ValuePredicate {

    public static Predicate gt(final String methodName,final double value){
           return new Predicate() {
                @Override
                public boolean evaluate(final Object object) {
                    try {
                        Method m = object.getClass().getDeclaredMethod(methodName);
                        return ((Double)m.invoke(object)) > value;
                    } catch (Exception e) {
                    }
                    return false;
                }
            };
    }

     public static Predicate gt(final String methodName,final long value){
           return new Predicate() {
                @Override
                public boolean evaluate(final Object object) {
                    try {
                        Method m = object.getClass().getDeclaredMethod(methodName);
                        return ((Long)m.invoke(object)) > value;
                    } catch (Exception e) {
                    }
                    return false;
                }
            };
    }
}
