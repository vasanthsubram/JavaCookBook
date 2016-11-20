package patterns.creational.builder.pizzaDemo;

// Abstract Builder

public abstract class PizzaBuilder {
	
	protected Pizza pizza;

	public Pizza getPizza() {
		createNewPizzaProduct();
		buildDough();
		buildSauce();
		buildTopping();
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}

	public abstract void buildDough();

	public abstract void buildSauce();

	public abstract void buildTopping();
}
