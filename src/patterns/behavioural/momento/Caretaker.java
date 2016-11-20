package patterns.behavioural.momento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	public static void main(String[] args) {
		List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();

		Originator originator = new Originator();
		originator.set("State1");
		originator.set("State2");
		savedStates.add(originator.saveStateToMemento());
		originator.set("State3");
		// We can request multiple mementos, and choose which one to roll back
		// to.
		savedStates.add(originator.saveStateToMemento());
		originator.set("State4");

		originator.restoreStateFromMemento(savedStates.get(1));
	}
}

