package patterns.behavioural.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		Subject subject = new Subject();
		View view = new View();

		subject.addObserver(view);
		// calling setValue on the subject
		// will trigger an update call to the view
		subject.setValue("test value");
	}

	static class Subject extends Observable {
		private String value;

		public void setValue(String s) {
			value = s;
			setChanged(); // set changed flag
			System.out.println("value changed in observer " + value);
			notifyObservers(value); // do notification
		}
	}

	static class View implements Observer {
		public void update(Observable o, Object str) {
			System.out.println("update recieved in observer : " + str.toString());
		}
	}
}
