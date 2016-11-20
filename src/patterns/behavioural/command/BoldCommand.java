package patterns.behavioural.command;

public class BoldCommand implements UndoableCommand {
	
	//the command always needs the target to work with
	private Document document;
	
	private String previousText;

	public BoldCommand(Document doc) {
		this.document = doc;
		previousText = this.document.getText();
	}

	public void execute() {
		System.out.println("Making text bold");
		document.boldSelection();
	}

	public void undo() {
		System.out.println("Undoing: text is not bold");
		document.setText(previousText);
	}
}