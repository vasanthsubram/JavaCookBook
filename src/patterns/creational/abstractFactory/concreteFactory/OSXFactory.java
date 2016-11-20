package patterns.creational.abstractFactory.concreteFactory;

import patterns.creational.abstractFactory.abstractFactories.GUIFactory;
import patterns.creational.abstractFactory.abstractProduct.TextBox;
import patterns.creational.abstractFactory.abstractProduct.Button;
import patterns.creational.abstractFactory.concreteProduct.OSXButton;
import patterns.creational.abstractFactory.concreteProduct.OSXTextBox;

public class OSXFactory implements GUIFactory {
    public Button createButton() {
        return new OSXButton();
    }

	@Override
	public TextBox createTextBox() {
		return new OSXTextBox();
	}
}

