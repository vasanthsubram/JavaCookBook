package patterns.creational.builder.pizzaDemo.concreteBuilders;

import patterns.creational.builder.pizzaDemo.PizzaBuilder;

public class PestoPizzaBuilder extends PizzaBuilder {

  public void buildDough() {
    pizza.setDough("cross");
  }

  public void buildSauce() {
    pizza.setSauce("pesto");
  }

  public void buildTopping() {
    pizza.setTopping("ham");
  }
}

