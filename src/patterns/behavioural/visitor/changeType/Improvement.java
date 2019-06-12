package patterns.behavioural.visitor.changeType;

import patterns.behavioural.visitor.Visitor;

public class Improvement implements Change {
  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
  // some code
}