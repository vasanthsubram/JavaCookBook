package patterns.creational.abstractFactory.abstractFactories;

import patterns.creational.abstractFactory.abstractProduct.Button;
import patterns.creational.abstractFactory.abstractProduct.TextBox;


public interface GUIFactory {

	public Button createButton();
	
	public TextBox createTextBox();
}

