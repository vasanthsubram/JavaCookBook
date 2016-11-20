package patterns.creational.abstractFactory.concreteProduct;

import patterns.creational.abstractFactory.abstractProduct.TextBox;

public class WinTextBox implements TextBox {

	public void paint() {
        System.out.println("I'm an WinTextBox");
    }
}
