package patterns.creational.abstractFactory.concreteProduct;

import patterns.creational.abstractFactory.abstractProduct.Button;

public class WinButton implements Button {
    public void paint() {
        System.out.println("I'm a WinButton");
    }
}
