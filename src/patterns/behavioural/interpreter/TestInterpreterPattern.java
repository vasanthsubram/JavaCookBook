package patterns.behavioural.interpreter;

import static org.junit.Assert.assertTrue;
import patterns.behavioural.interpreter.ruleExpressions.AndExpression;
import patterns.behavioural.interpreter.ruleExpressions.AttributeExpression;
import patterns.behavioural.interpreter.ruleExpressions.EqualsExpression;
import patterns.behavioural.interpreter.ruleExpressions.OrExpression;
import patterns.behavioural.interpreter.ruleExpressions.ValueExpression;
import patterns.utils.LoanObject;
import patterns.utils.Money;


public class TestInterpreterPattern {

	public static void main(String[] args) {

		LoanObject loan = new LoanObject(new Money(20000.0), "CA");
		loan.getLoanCollateral().setCollateralValue(new Money(500000));

		AttributeExpression amount = new AttributeExpression(
				"patterns.utils.LoanObject", "getLoanAmount");
		ValueExpression amountVal = new ValueExpression(new Money(20000.00));

		AttributeExpression state = new AttributeExpression(
				"patterns.utils.LoanObject", "getLoanState");
		ValueExpression stateVal = new ValueExpression("TX");

		EqualsExpression amountExp = new EqualsExpression(amount, amountVal);
		System.out.println(amountExp.evaluateAgainst(loan));

		EqualsExpression stateExp = new EqualsExpression(state, stateVal);
		System.out.println(stateExp.evaluateAgainst(loan));

		//Does an 'and' operation on two other boolean expressions
		OrExpression andExp = new OrExpression(amountExp, stateExp);
		assertTrue(andExp.evaluateAgainst(loan));
		// System.out.println(new Money(123.45).add(new Money(-100.41)));
	}

}
