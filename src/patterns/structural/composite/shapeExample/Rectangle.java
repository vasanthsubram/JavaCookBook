package patterns.structural.composite.shapeExample;

import java.util.ArrayList;
import java.util.List;


public class Rectangle implements IShape {

	List<IShape> rectangleEdges = new ArrayList<IShape>();

	public Rectangle() {
		rectangleEdges.add(new Line(0,0,1,0));
		rectangleEdges.add(new Line(1,0,1,1));
		rectangleEdges.add(new Line(1,1,0,1));
		rectangleEdges.add(new Line(0,0,0,0));
	}
	public Rectangle(List<IShape> edges){
		rectangleEdges = edges;
	}

	public void addToShape(IShape newLine) {
		if(rectangleEdges.size()==4){
			throw new RuntimeException("cannot more than 4 edges to a rectangle");
		}
		rectangleEdges.add(newLine);
	}
	
	public void renderShapeToScreen() {
		for (IShape s : rectangleEdges) {
			s.renderShapeToScreen();
		}
	}

	@Override
	public void move(int x, int y) {
		for (IShape s : rectangleEdges) {
			s.move(x,y);
		}
	}
}

