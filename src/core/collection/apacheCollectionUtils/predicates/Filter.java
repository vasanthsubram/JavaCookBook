package core.collection.apacheCollectionUtils.predicates;

import core.comparator.Compare;
import core.enums.CompOp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.Validate;
import utils.Employee;

public class Filter {

    private List<Employee> entities;
    private String name;
    private CompOp operation;
    private Double targetSalary;
    
    public Filter(List<Employee> objects) {
        entities = objects;
    }

    public Filter withNamesLike(String name) {
        this.name = name;
        return this;
    }

    public Filter withMoreThan(){
        this.operation=CompOp.GT;
        return this;
    }

     public Filter withEqualOrMoreThan(){
        this.operation=CompOp.GTE;
        return this;
    }
     
     public Filter withLessThan(){
        this.operation=CompOp.LT;
        return this;
    }

      public Filter withEqualOrLessThan(){
        this.operation=CompOp.LTE;
        return this;
    }

      public Filter with(){
        this.operation=CompOp.EQ;
        return this;
    }
   

    public Filter salary(double compareSalary){
        this.targetSalary=compareSalary;
        return this;
    }

    public List<Employee> filter() {
        List<Employee> filtered = new ArrayList<Employee>();
        CollectionUtils.select(entities, getPredicate(), filtered);
        return filtered;
    }

    protected Predicate getPredicate() {
        return new Predicate() {

            @Override
            public boolean evaluate(final Object object) {
                Validate.isTrue(object instanceof Object);
                final Employee employee = (Employee) object;
                return employee.getName().contains(name) &&
                           ((targetSalary != null) && (Compare.doIt(employee.getSalary(), targetSalary, operation)));
            }
        };
    }

    public static void main(String[] args) {
      List list = new ArrayList();
      list.add(new Employee("Emp1", 34, 2000, 1,1));
      list.add(new Employee("Emp12", 200, 1980, 1,1));
      list.add(new Employee("Emp3", 1, 2000, 1,1));

      List<Employee> result = new Filter(list).withNamesLike("Emp1").filter();
      for(Employee s: result){
          System.out.println(s.getName());
      }

      result = new Filter(list).withNamesLike("Emp1").withLessThan().salary(200).filter();
      for(Employee s: result){
          System.out.println(s.getName());
      }
    }
}
