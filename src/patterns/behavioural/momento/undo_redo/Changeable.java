package patterns.behavioural.momento.undo_redo;

public interface Changeable {
  void undo();
  void redo();
}