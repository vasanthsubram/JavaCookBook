package core.basicJava;

public class TestCloning {

	/** Creates a new instance of TestCloning */
	public static void main(String args[]) {
		CloneableObj a = new CloneableObj();
		try {
			Cloneable b = (Cloneable) a.clone();

			System.out.println("original and clone are not identical = "
					+ (a != b));
			System.out.println(b.getClass());
			System.out.println(a.someInt == ((CloneableObj) b).someInt);
			a.someInt = 20;
			System.out.println(a.someInt == ((CloneableObj) b).someInt);
		} catch (CloneNotSupportedException ex) {
			System.out.println("Cloning not supported");
		}

	}

}

class CloneableObj implements Cloneable {
	int someInt = 100;
	
	protected Object clone() throws CloneNotSupportedException {
		Object copy = super.clone();
		return copy;
	}
}