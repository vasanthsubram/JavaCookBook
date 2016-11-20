package patterns.behavioural.visitor.elements;

import patterns.behavioural.visitor.interfaces.CarElement;
import patterns.behavioural.visitor.interfaces.CarElementVisitor;

public class Engine implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
 
