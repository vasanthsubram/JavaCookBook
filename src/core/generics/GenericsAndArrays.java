package core.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericsAndArrays<T> {

    public static void main(String[] args) {
        Integer[] arr = new GenericsAndArrays<Integer>().createArrayFor(Integer.class);
        arr[0]=2;
        arr[1]=23;
        System.out.println(Arrays.toString(arr));
    }

    T[]createArrayFor(Class<T> clazz){
         return (T[]) Array.newInstance(clazz, 32);
    }
}
