package patterns.behavioural.visitor.interfaces;

public interface CarElement {
	 // CarElements have to provide accept().
    void accept(CarElementVisitor visitor);
}

