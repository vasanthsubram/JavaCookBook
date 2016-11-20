package patterns.behavioural.strategy.arithmeticExample;

import patterns.behavioural.strategy.arithmeticExample.strategy.IStrategy;

public class Context {
 
    private IStrategy strategy;
 
    // Constructor
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }
 
    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

