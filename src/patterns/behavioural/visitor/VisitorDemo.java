package patterns.behavioural.visitor;

import patterns.behavioural.visitor.elements.Car;
import patterns.behavioural.visitor.visitors.CarElementDoVisitor;
import patterns.behavioural.visitor.visitors.CarElementPrintVisitor;

public  class VisitorDemo {
    static public void main(String[] args){
        Car car = new Car();
        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
