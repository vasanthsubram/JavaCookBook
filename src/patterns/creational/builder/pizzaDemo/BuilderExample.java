package patterns.creational.builder.pizzaDemo;

import patterns.creational.builder.pizzaDemo.concreteBuilders.HawaiianPizzaBuilder;
import patterns.creational.builder.pizzaDemo.concreteBuilders.SpicyPizzaBuilder;


public class BuilderExample {

	public static void main(String[] args) {

		
		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

		Pizza hawaiian = hawaiianPizzaBuilder.getPizza();

		Pizza spicy = spicyPizzaBuilder.getPizza();
	}
}
