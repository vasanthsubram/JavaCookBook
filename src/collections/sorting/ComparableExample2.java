package collection_lambda.collection.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ComparableExample2 {
  public static void main(String[] args) {

    //Array
    int[] arr = {8,4,2,1};
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    String[] strArr={"2 medium","1 small","3 large"};
    System.out.println(Arrays.toString(strArr));

    Arrays.sort(strArr);
    System.out.println(Arrays.toString(strArr));


    //Collection
    ArrayList<String> list = new ArrayList<>();

    list.add("E");
    list.add("A");
    list.add("C");
    list.add("B");
    list.add("D");

    Collections.sort(list);
    System.out.println(list);

    //Sort in reverse natural order
    Collections.sort(list, Collections.reverseOrder());

    System.out.println(list);

  }



}
