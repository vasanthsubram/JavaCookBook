package patterns.behavioural.visitor;

import patterns.behavioural.visitor.changeType.Change;
import patterns.behavioural.visitor.changeType.Growth;
import patterns.behavioural.visitor.changeType.Improvement;
import patterns.behavioural.visitor.changeType.Refactoring;

/**
 * Breaks the Open/Close principal
 *
 */
public class ChangeProcessingHandler_problemCode {

  public CodeDelta triggerProcessingChangeOf(Code code, Change change) throws UnsuportedChangeException{
    verifyChangeOf(code, change);

    if (change instanceof Refactoring) {
      return processRefactoring(code, (Refactoring) change);
    } else if (change instanceof Improvement)  {
      return processImprovement(code, (Improvement) change);
    } else if (change instanceof Growth) {
      return processGrowth(code, (Growth) change);
    } else {
      throw new UnsuportedChangeException();
    }
  }

  private void verifyChangeOf(Code code, Change change) {

  }

  private CodeDelta processGrowth(Code code, Growth change) {
    return new CodeDelta();
  }

  private CodeDelta processImprovement(Code code, Improvement change) {
    return new CodeDelta();
  }

  private CodeDelta processRefactoring(Code code, Refactoring change) {
    return new CodeDelta();
  }


  static class CodeDelta{

  }

  static class UnsuportedChangeException extends Throwable{
    public UnsuportedChangeException(){};
  }
}


