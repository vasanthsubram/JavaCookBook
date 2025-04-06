package collection_lambda.collection.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class DeleteElementInArray {

  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,5,6,7};
    //removing number 1
    numbers =(int[]) ArrayUtils.removeElement(numbers, 1);
    System.out.println(Arrays.toString(numbers));
  }
}
