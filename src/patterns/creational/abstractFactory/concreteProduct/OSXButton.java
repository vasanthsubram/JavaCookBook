package patterns.creational.abstractFactory.concreteProduct;

import patterns.creational.abstractFactory.abstractProduct.Button;

public class OSXButton implements Button {
    public void paint() {
        System.out.println("I'm an OSXButton");
    }
}

