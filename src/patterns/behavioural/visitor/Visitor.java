package patterns.behavioural.visitor;

import patterns.behavioural.visitor.changeType.Growth;
import patterns.behavioural.visitor.changeType.Improvement;
import patterns.behavioural.visitor.changeType.Refactoring;

public interface Visitor {
  void visit(Refactoring refactoring);
  void visit(Improvement improvement);
  void visit(Growth growth);
}