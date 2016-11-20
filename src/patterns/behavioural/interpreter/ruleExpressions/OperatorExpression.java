package patterns.behavioural.interpreter.ruleExpressions;



public abstract class OperatorExpression implements IRuleExpression {

	protected IRuleExpression left;
	protected IRuleExpression right;

	public IRuleExpression getLeft() {
		return left;
	}

	public IRuleExpression getRight() {
		return right;
	}

}
