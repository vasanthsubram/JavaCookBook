package patterns.structural.decorator.windowExample;


public class HorizontalScrollBarDecorator implements IWindow  {	

	protected IWindow decoratedWindow;

	public HorizontalScrollBarDecorator(IWindow decoratedWindow) {
		this.decoratedWindow = decoratedWindow;
	}
	
	public void draw() {
		decoratedWindow.draw();
		drawHorizontalScrollBar();
	}

	private void drawHorizontalScrollBar() {
		// draw the horizontal scrollbar
	}

	public String getDescription() {
		return decoratedWindow.getDescription()	+ ", including horizontal scrollbars";
	}
}

