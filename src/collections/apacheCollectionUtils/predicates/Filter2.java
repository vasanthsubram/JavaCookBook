package collections.apacheCollectionUtils.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import utils.Employee;


public class Filter2 {

     public static void main(String[] args) {
      List list = new ArrayList();
      list.add(new Employee("Emp1", 34, 2000, 1,1));
      list.add(new Employee("Emp12", 200, 1980, 1,1));
      list.add(new Employee("Emp3", 1, 2000, 1,1));

      List<Employee> emps=(List<Employee>) CollectionUtils.select(list, PredicateUtils.allPredicate(
              Arrays.asList(StringPredicate.contains("getName","Emp1"), ValuePredicate.gt("getSalary", 199))));
      for(Employee e: emps){
          System.out.println(e.getName());
      }
    }
}
