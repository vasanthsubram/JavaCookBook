package patterns.behavioural.visitor.elements;

import patterns.behavioural.visitor.interfaces.CarElement;
import patterns.behavioural.visitor.interfaces.CarElementVisitor;

public class Body implements CarElement {
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

