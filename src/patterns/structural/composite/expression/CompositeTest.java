package patterns.structural.composite.expression;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Milan.Nikic on 8/23/2016.
 */
public class CompositeTest {

    @Test
    public void testConstant() {
        Expression e = new Constant(1.0);
        assertEquals(1, e.calculate(), 0.0);
    }

    @Test
    public void testNegate() {
        Expression e = new Negate(new Constant(- 1.0));
        assertEquals(1, e.calculate(), 0.0);
    }

    @Test
    public void testAdder() {
        Expression e = new Add(new Constant(1.0), new Constant(2.0));
        assertEquals(3, e.calculate(), 0.0);
    }

    @Test
    public void testSubtracter() {
        Expression e = new Subtract(new Constant(1.0), new Constant(2.0));
        assertEquals(-1, e.calculate(), 0.0);
    }

    @Test
    public void testMultiplier() {
        Expression e = new Multiply(new Constant(5.0), new Constant(2.0));
        assertEquals(10, e.calculate(), 0.0);
    }

    @Test
    public void testDivider() {
        Expression e = new Divide(new Constant(5.0), new Constant(2.0));
        assertEquals(2.5, e.calculate(), 0.0);
    }

    /*
        -5*(9/6)
        --------
        7+(2-1.5)
     */
    @Test
    public void testComplex() {
        Expression e =
                new Divide(
                        new Multiply(
                                new Negate(new Constant(5.0)),
                                new Divide(new Constant(9.0), new Constant(6.0))
                        ),
                        new Add(
                                new Constant(7.0),
                                new Subtract(new Constant(2.0), new Constant(1.5))
                        )
                );
        assertEquals(-1, e.calculate(), 0.0);
    }
}
