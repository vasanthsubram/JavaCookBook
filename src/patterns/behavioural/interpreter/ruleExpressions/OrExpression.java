/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package patterns.behavioural.interpreter.ruleExpressions;

/**
 *
 * @author cuttle-fish
 */
public class OrExpression  extends OperatorExpression {

	public OrExpression(IRuleExpression l, IRuleExpression r) {
		left = l;
		right = r;
	}

	@Override
	public Boolean evaluateAgainst(Object obj) {
		return ((Boolean) (this.getLeft().evaluateAgainst(obj)) | (Boolean) (this
				.getRight().evaluateAgainst(obj)));
	}
}
