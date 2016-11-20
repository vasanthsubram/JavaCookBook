package patterns.structural.composite.shapeExample;

import java.util.ArrayList;
import java.util.List;

public class ComplexShape implements IShape {

	List<IShape> shapeList = new ArrayList<IShape>();

	public void addToShape(IShape shapeToAddToCurrentShape) {
		shapeList.add(shapeToAddToCurrentShape);
	}

	public void renderShapeToScreen() {
		for(IShape s: shapeList){
			s.renderShapeToScreen();
		}	
	}

	@Override
	public void move(int x, int y) {
		for(IShape s: shapeList){
			s.move(x,y);
		}	
	}
}

