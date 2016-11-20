package patterns.behavioural.command;

import java.util.Stack;

public class CommandManager {
	
	private Stack<Command> commandStack = new Stack<Command>();

	public static void main(String[] args) {
		CommandManager manager = new CommandManager();
		Document doc = new Document("Helo World");
		Command bold = new BoldCommand(doc);
		manager.executeCommand(bold);
		manager.undo();
	}

	public void executeCommand(Command cmd) {
		cmd.execute();
		if (cmd instanceof UndoableCommand) {
			commandStack.push(cmd);
		}
	}

	public void undo() {
		if (commandStack.size() > 0) {
			UndoableCommand cmd = (UndoableCommand) commandStack.pop();
			cmd.undo();
		}
	}
}