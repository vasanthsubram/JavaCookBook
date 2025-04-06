package collections.apacheCollectionUtils.closures;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author vsubramanian
 */
public class SimpleClosuresDemo {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Gold", "Silver", "Copper");
        CollectionUtils.forAllDo(strings, new Closure() {
            public void execute(Object o) {
                System.out.print(o.toString() + " ");
            }
        });
        System.out.println();

        //or create a closure singleton (PrintIt) and use it here
        CollectionUtils.forAllDo(strings, PrintIt.getInstance());
    }
}
