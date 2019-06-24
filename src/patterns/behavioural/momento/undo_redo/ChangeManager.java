package patterns.behavioural.momento.undo_redo;

public class ChangeManager {

  private Node currentIndex = null;

  //the parent node far left node.
  private Node parentNode = new Node();

  public ChangeManager(){
    currentIndex = parentNode;
  }

  public void clear(){
    currentIndex = parentNode;
  }

  public void addChangeable(Changeable changeable){
    Node node = new Node(changeable);
    currentIndex.right = node;
    node.left = currentIndex;
    currentIndex = node;
    print();
  }

  public void undo(){
    if ( !canUndo() ){
      throw new IllegalStateException("Cannot undo. Index is out of range.");
    }
    currentIndex.changeable.undo();
    moveLeft();
    print();
  }

  public void redo(){
    if ( !canRedo() ){
      throw new IllegalStateException("Cannot redo. Index is out of range.");
    }
    moveRight();
    currentIndex.changeable.redo();
    print();
  }


  public boolean canUndo(){
    return currentIndex != parentNode;
  }

  public boolean canRedo(){
    return currentIndex.right != null;
  }

  private void moveLeft(){
    if ( currentIndex.left == null ){
      throw new IllegalStateException("Internal index set to null.");
    }
    currentIndex = currentIndex.left;
  }

  private void moveRight(){
    if ( currentIndex.right == null ){
      throw new IllegalStateException("Internal index set to null.");
    }
    currentIndex = currentIndex.right;
  }



  private void print(){
    currentIndex.print();
  }
  private class Node {
    private Node left = null;
    private Node right = null;
    private final Changeable changeable;

    public Node(Changeable c){
      changeable = c;
    }

    public Node(){
      changeable = null;
    }

    void print(){
      System.out.print(changeable);
      System.out.print("->");
      if(right!=null){
        right.print();
      } else{
        System.out.println();
      }
    }
  }
}