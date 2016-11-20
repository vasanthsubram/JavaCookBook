package core.collection.apacheCollectionUtils;

import java.util.Arrays;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author vsubramanian
 */
public class CollectionUtilsDemo {

    public static void main(String[] args) {
        String[] arr = {"Gold", "Silver", "Copper"};
        CollectionUtils.reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
