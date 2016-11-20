package patterns.behavioural.visitor.visitors;

import patterns.behavioural.visitor.elements.Body;
import patterns.behavioural.visitor.elements.Car;
import patterns.behavioural.visitor.elements.Engine;
import patterns.behavioural.visitor.elements.Wheel;
import patterns.behavioural.visitor.interfaces.CarElementVisitor;

public class CarElementDoVisitor implements CarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my "+ wheel.getName() + " wheel");
    }
 
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
 
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
 
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
}

