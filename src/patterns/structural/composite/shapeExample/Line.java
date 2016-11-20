package patterns.structural.composite.shapeExample;

public class Line implements IShape {
	
	int x1,y1,x2,y2;
	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}

	public void addToShape(IShape shapeToAddToCurrentShape) {
		throw new RuntimeException("cannot add to line");
	}
	
	public void renderShapeToScreen() {
		System.out.println("Line: " + "x1=" + x1+ " y1="+y1 + " x2="+x2+" y2"+y2 );
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
	}
}

