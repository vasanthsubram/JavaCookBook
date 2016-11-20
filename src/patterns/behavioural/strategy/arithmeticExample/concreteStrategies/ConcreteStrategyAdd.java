package patterns.behavioural.strategy.arithmeticExample.concreteStrategies;

import patterns.behavioural.strategy.arithmeticExample.strategy.IStrategy;

public class ConcreteStrategyAdd implements IStrategy {
 
    public int execute(int a, int b) {
        System.out.println("add " + a+b);
        return a + b;  
    }
}

