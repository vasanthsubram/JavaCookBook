package patterns.behavioural.visitor.visitors;

import patterns.behavioural.visitor.elements.Body;
import patterns.behavioural.visitor.elements.Car;
import patterns.behavioural.visitor.elements.Engine;
import patterns.behavioural.visitor.elements.Wheel;
import patterns.behavioural.visitor.interfaces.CarElementVisitor;

public class CarElementPrintVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {      
        System.out.println("Visiting "+ wheel.getName()
                            + " wheel");
    }
 
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
 
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
 
    public void visit(Car car) {      
        System.out.println("Visiting car");
    }
}

