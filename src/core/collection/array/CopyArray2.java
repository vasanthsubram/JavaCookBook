package core.collection.array;

import utils.Employee;

import java.util.Arrays;

public class CopyArray2 {

  public static void main(String[] args){
    int[] arr = {1,2,3};
    int[] arr2 = new int[arr.length];
    System.arraycopy(arr,0,arr2,0,arr.length);
    System.out.println(Arrays.toString(arr2));

    Integer[] arr3 = {1,2,3};
    Integer[] arr4 = new Integer[arr3.length];
    System.arraycopy(arr3,0,arr4,0,arr3.length);
    System.out.println(Arrays.toString(arr3));
    System.out.println(arr3[0]== arr4[0]);

    // arrayCopy of objects only copies the pointers; does not create new objects
    Employee emp1 = new Employee("Name1", 10000, 2000,1,1);
    Employee emp2 = new Employee("Name2", 20000, 2010,2,2);

    Employee[] empArr = (Employee[])Arrays.asList(emp1,emp2).toArray();

    Employee[] empArr2 = new Employee[empArr.length];
    System.arraycopy(empArr,0,empArr2,0, empArr.length);
    System.out.println(Arrays.toString(empArr2));

    System.out.println(empArr[0]==empArr2[0]);

  }
}
