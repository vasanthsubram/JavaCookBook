package patterns.behavioural.strategy.arithmeticExample.concreteStrategies;

import patterns.behavioural.strategy.arithmeticExample.strategy.IStrategy;

public class ConcreteStrategySubtract implements IStrategy {
 
    public int execute(int a, int b) {
        System.out.println("Subtract: " + (a-b));
        return a - b;  
    }
}

