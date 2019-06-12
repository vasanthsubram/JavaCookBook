package patterns.behavioural.visitor.changeType;

import patterns.behavioural.visitor.Visitor;

public interface Change {
  void accept(Visitor visitor);
}