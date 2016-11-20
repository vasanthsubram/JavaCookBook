package patterns.creational.abstractFactory.concreteFactory;

import patterns.creational.abstractFactory.abstractFactories.GUIFactory;
import patterns.creational.abstractFactory.abstractProduct.Button;
import patterns.creational.abstractFactory.abstractProduct.TextBox;
import patterns.creational.abstractFactory.concreteProduct.WinButton;
import patterns.creational.abstractFactory.concreteProduct.WinTextBox;

public class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

	@Override
	public TextBox createTextBox() {
		return new WinTextBox();
	}
}

