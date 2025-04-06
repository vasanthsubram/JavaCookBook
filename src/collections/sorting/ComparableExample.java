package collection_lambda.collection.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

  public static void main(String[] args){
    List<Employee> list = new ArrayList<>();
    list.add(new Employee(10));
    list.add(new Employee(2));
    list.add(new Employee(1));

    System.out.println(list);

    Collections.sort(list);

    System.out.println(list);

  }
}


class Employee implements Comparable<Employee> {

  private Integer id;

  public Employee(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public int compareTo(Employee o) {
    return this.getId().compareTo( o.getId() );
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + id + '}';
  }
}