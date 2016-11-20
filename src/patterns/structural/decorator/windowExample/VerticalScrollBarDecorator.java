package patterns.structural.decorator.windowExample;


public class VerticalScrollBarDecorator implements IWindow   {

	protected IWindow decoratedWindow;

	public VerticalScrollBarDecorator(IWindow decoratedWindow) {
		this.decoratedWindow = decoratedWindow;
	}

	public void draw() {
		decoratedWindow.draw();
		drawVerticalScrollBar();
	}

	private void drawVerticalScrollBar() {
		// draw the vertical scrollbar
	}

	public String getDescription() {
		return decoratedWindow.getDescription()	+ ", including vertical scrollbars";
	}
}

