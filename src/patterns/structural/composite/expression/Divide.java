package patterns.structural.composite.expression;

/**
 * Created by Milan.Nikic on 8/23/2016.
 */
public class Divide extends BinaryExpression {

    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() / right.calculate();
    }
}
