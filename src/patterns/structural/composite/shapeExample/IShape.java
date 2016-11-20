package patterns.structural.composite.shapeExample;

/**
 * IShape represents a generic shape that could be simple or complex.
 * Complex shape is a composite of simple shapes
 * @author chq-vasanthakumars
 *
 */
public interface IShape {

	public void renderShapeToScreen();

	public void addToShape(IShape shapeToAddToCurrentShape);
	
	public void move(int x, int y);
	
}
