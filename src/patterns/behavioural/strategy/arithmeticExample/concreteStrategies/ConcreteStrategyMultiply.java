package patterns.behavioural.strategy.arithmeticExample.concreteStrategies;

import patterns.behavioural.strategy.arithmeticExample.strategy.IStrategy;

public class ConcreteStrategyMultiply implements IStrategy {
 
    public int execute(int a, int b) {
        System.out.println("Multiply: " + a*b);
        return a * b;  
    }
}

