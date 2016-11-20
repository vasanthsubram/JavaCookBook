package patterns.behavioural.visitor.interfaces;

import patterns.behavioural.visitor.elements.Body;
import patterns.behavioural.visitor.elements.Car;
import patterns.behavioural.visitor.elements.Engine;
import patterns.behavioural.visitor.elements.Wheel;

public interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}

