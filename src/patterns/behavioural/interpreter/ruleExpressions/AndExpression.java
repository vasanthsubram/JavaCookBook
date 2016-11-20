package patterns.behavioural.interpreter.ruleExpressions;


public class AndExpression extends OperatorExpression {

	public AndExpression(IRuleExpression l, IRuleExpression r) {
		left = l;
		right = r;
	}

	@Override
	public Boolean evaluateAgainst(Object obj) {
		return ((Boolean) (this.getLeft().evaluateAgainst(obj)) & (Boolean) (this
				.getRight().evaluateAgainst(obj)));
	}
}
