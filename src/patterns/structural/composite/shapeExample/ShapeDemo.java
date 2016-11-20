package patterns.structural.composite.shapeExample;


public class ShapeDemo {

	public static void main(String[] args) {
		IShape lineShape = new Line(0, 0, 1, 1);

		IShape rectangelShape = new Rectangle();

		ComplexShape complexShape = new ComplexShape();

		// complex shape is made of the rectangle and the line
		complexShape.addToShape(rectangelShape);

		complexShape.addToShape(lineShape);
		
		complexShape.renderShapeToScreen();

	}
}

