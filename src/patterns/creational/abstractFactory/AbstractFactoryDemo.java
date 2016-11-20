package patterns.creational.abstractFactory;

import patterns.creational.abstractFactory.abstractFactories.GUIFactory;
import patterns.creational.abstractFactory.abstractProduct.Button;
import patterns.creational.abstractFactory.abstractProduct.TextBox;
import patterns.creational.abstractFactory.concreteFactory.OSXFactory;
import patterns.creational.abstractFactory.concreteFactory.WinFactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		GUIFactory guiFactory;
		String sys = "OSX";
		if (sys.equals("WINDOWS")) {
			guiFactory = new WinFactory();
		} else {
			guiFactory = new OSXFactory();
		}
		
		Button button = guiFactory.createButton();
        button.paint();

        TextBox textBox = guiFactory.createTextBox();
        textBox.paint();
	}
}
