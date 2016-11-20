package patterns.structural.decorator.windowExample;

public class DecoratorDemo {
	
	public static void main(String[] args) {
		// create a decorated Window with horizontal and vertical scrollbars
		IWindow decoratedWindow = new HorizontalScrollBarDecorator(
				new VerticalScrollBarDecorator(new SimpleWindow()));

		// print the Window's description
		System.out.println(decoratedWindow.getDescription());
	}
}
