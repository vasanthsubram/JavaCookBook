package lambda;

import utils.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {

		Runnable r = () -> System.out.println("Hello World");
		new Thread(r).start();

		List<Employee> empList = Employee.shortList();
		// Lambda supports 'target typing' - compiler deducts e1 and e2 are
		// Employee type
		Collections.sort(empList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		empList.forEach(n -> System.out.println(n));

		List<Integer> list = Arrays.asList(1, 2, 3);
		list.forEach(n -> System.out.println(n));


		list.forEach(System.out::println);
	}

}
