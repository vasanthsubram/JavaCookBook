package core.collection.array;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class ApacheArrayUtils {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{4,5,6};

       int[] result= ArrayUtils.addAll(arr1,arr2);
        System.out.println(Arrays.toString(result));    //1,2,3,4,5,6

        System.out.println(Arrays.toString(ArrayUtils.EMPTY_BYTE_ARRAY));
        System.out.println(ArrayUtils.contains(arr1, 3));

        Integer[] arr3 = ArrayUtils.toObject(arr2);
        System.out.println(Arrays.toString(arr3));

        System.out.println(ArrayUtils.indexOf(arr2,5));

        //removeElement returns a new array 
        System.out.println("Remove Element  => " + ArrayUtils.toString(ArrayUtils.removeElement(arr2, 4)));
        System.out.println(ArrayUtils.removeElement(arr2, 4) == arr2);

        ArrayUtils.reverse(arr2);
        System.out.println("Reverse array  => " + Arrays.toString(arr2));
    }
}
