package patterns.behavioural.visitor;

import patterns.behavioural.visitor.changeType.Growth;
import patterns.behavioural.visitor.changeType.Improvement;
import patterns.behavioural.visitor.changeType.Refactoring;

public class ChangeProcessor implements Visitor {
  private final Code code;
  public ChangeProcessor(Code code) {
    this.code = code;
  }
  @Override
  public void visit(Refactoring refactoring) {
    // some code
  }
  @Override
  public void visit(Improvement improvement) {
    // some code
  }
  @Override
  public void visit(Growth growth) {
    // some code
  }
}