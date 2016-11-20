package core.collection.sorting;

import java.util.Comparator;
import java.util.TreeSet;

public class SortingByComparators {
	public static void main(String[] args) {
		TreeSet<Employee> treeSet = new TreeSet(Employee.salaryComparator);
		treeSet.add(new Employee(9000.89F));
		treeSet.add(new Employee(900));
		treeSet.add(new Employee(2000));
		treeSet.add(new Employee(1000));
		for (Employee e : treeSet) {
			System.out.println(e.toString());
		}
	}
} 

class Employee {
	float salaryAmt;

	public Employee(float amt) {
		salaryAmt = amt;
	}

	public static Comparator salaryComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return (int) (e1.salary() - e2.salary());
		}
	};

	public float salary() {
		return salaryAmt;
	}

	public String toString() {
		return "Employee with salary " + salaryAmt;
	}
}