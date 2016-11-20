package patterns.behavioural.visitor.elements;

import patterns.behavioural.visitor.interfaces.CarElement;
import patterns.behavioural.visitor.interfaces.CarElementVisitor;

public class Wheel implements CarElement {
    private String name;
 
    public Wheel(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
