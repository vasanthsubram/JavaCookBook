package patterns.behavioural.strategy.arithmeticExample;

import patterns.behavioural.strategy.arithmeticExample.concreteStrategies.ConcreteStrategyAdd;
import patterns.behavioural.strategy.arithmeticExample.concreteStrategies.ConcreteStrategyMultiply;
import patterns.behavioural.strategy.arithmeticExample.concreteStrategies.ConcreteStrategySubtract;

public class StrategyDemo {
 
    public static void main(String[] args) {
 
        Context context;
 
        // Three contexts following different strategies
        context = new Context(new ConcreteStrategyAdd());
        int resultA = context.executeStrategy(3,4);
 
        context = new Context(new ConcreteStrategySubtract());
        int resultB = context.executeStrategy(3,4);
 
        context = new Context(new ConcreteStrategyMultiply());
        int resultC = context.executeStrategy(3,4);
    }
}
