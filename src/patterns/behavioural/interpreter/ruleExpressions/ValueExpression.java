package patterns.behavioural.interpreter.ruleExpressions;



public class ValueExpression implements IRuleExpression {

	private Object value;

	public ValueExpression(Object aValue) {
		value = aValue;
	}

	public Object evaluateAgainst(Object obj) {
		return value;
	}

	public void setValue(Object obj) {
		value = obj;
	}
}
