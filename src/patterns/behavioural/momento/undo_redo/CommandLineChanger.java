package patterns.behavioural.momento.undo_redo;

public class CommandLineChanger implements Changeable{

  private final String val;

  public CommandLineChanger(String v){
    super();
    this.val = v;
  }

  public void undo(){
    System.out.println(val + " undone");
  }

  public void redo(){
    System.out.println(val + " redone");
  }

  @Override
  public String toString(){
    return val;
  }
}
