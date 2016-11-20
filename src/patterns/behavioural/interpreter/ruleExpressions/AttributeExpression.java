package patterns.behavioural.interpreter.ruleExpressions;
import java.lang.reflect.*;

public class AttributeExpression implements IRuleExpression {
	
	protected Method method;

	public AttributeExpression(Method aMethod){
		method = aMethod;
	}
	
	public AttributeExpression(String className, String methodName){
		try{
			method = Class.forName(className).getDeclaredMethod(methodName);
		}
		catch(Throwable t){
			throw new RuntimeException(t);
		}
	}
	
	
	public void setMethod(Method aMethod){
		method = aMethod;
	}
	
	public Object evaluateAgainst(Object obj) {
		try{
			return(method.invoke(obj));
		}
		catch(Throwable t){
			throw new RuntimeException(t);
		}
	}
}
