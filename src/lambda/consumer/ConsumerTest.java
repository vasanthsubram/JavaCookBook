package lambda.consumer;

import java.util.function.Consumer;

import utils.Employee;

//Consumers represents operations to be performed on a single input argument.
//Accepts one Argument and eturns nothing.
public class ConsumerTest {
	public static void main(String[] args) {
	
		Consumer<Employee> greeter = (p) -> System.out.println("Hello, " + p.getName());
		greeter.accept(new Employee("Luke Skywalker"));
	}
}
