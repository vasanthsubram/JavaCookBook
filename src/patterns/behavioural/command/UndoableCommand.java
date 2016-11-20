package patterns.behavioural.command;

public interface UndoableCommand extends Command{

	public void undo();
}
