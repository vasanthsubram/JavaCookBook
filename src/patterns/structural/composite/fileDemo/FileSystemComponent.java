package patterns.structural.composite.fileDemo;

public abstract class FileSystemComponent {
	String name;

	public FileSystemComponent(String cName) {
		name = cName;
	}

	public void addComponent(FileSystemComponent component){
		throw new RuntimeException("Invalid Operation. Not Supported");
	}

	public FileSystemComponent getComponent(int componentNum){
		throw new RuntimeException("Invalid Operation. Not Supported");
	}

	public abstract long getComponentSize();
} 