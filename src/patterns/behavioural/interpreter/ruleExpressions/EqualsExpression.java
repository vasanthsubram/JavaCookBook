package patterns.behavioural.interpreter.ruleExpressions;



public class EqualsExpression extends OperatorExpression {

	public EqualsExpression(IRuleExpression l, IRuleExpression r) {
		left = l;
		right = r;
	}

	public Boolean evaluateAgainst(Object obj) {
		return (this.getLeft().evaluateAgainst(obj).equals(this.getRight()
				.evaluateAgainst(obj)));
	}
}
