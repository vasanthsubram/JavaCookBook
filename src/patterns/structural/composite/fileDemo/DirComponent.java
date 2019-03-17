package patterns.structural.composite.fileDemo;

import java.util.Enumeration;
import java.util.Vector;

public class DirComponent extends FileSystemComponent {
	Vector dirContents = new Vector();

	public DirComponent(String cName) {
		super(cName);
	}

	public void addComponent(FileSystemComponent fc){
		dirContents.add(fc);
	}

	public FileSystemComponent getComponent(int location){
		return (FileSystemComponent) dirContents.elementAt(location);
	}

	public long getComponentSize() {
		long sizeOfAllFiles = 0;
		Enumeration e = dirContents.elements();
		while (e.hasMoreElements()) {
			FileSystemComponent component = (FileSystemComponent) e.nextElement();
			sizeOfAllFiles = sizeOfAllFiles + (component.getComponentSize());
		}
		return sizeOfAllFiles;
	}
} 

