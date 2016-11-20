package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.Employee;

public class LambdaFunctionsTest {

	public static void main(String[] args) {

		Runnable r = () -> System.out.println("Hello World");
		new Thread(r).start();

		List<Employee> empList = Employee.shortList();
		// Lambda supports 'target typing' - compiler deducts e1 and e2 are
		// Employee type
		Collections.sort(empList,
				(e1, e2) -> e1.getName().compareTo(e2.getName()));
		empList.forEach(n -> System.out.println(n));

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println(n));

		list.forEach(System.out::println);
	}

}
