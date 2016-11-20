package core.basicJava;

/*
 Static variables in Java are not inherited, they exist only in the class which declares them; 
 however, they can be accessed implicitly by referring to an instance or subclass (or subclass instance) 
 of the class which defines the static variable
 */
public class StaticInheritence {

	public static void main(String args[]) {
		new Child().print();
	}
}

class Parent {
	static int x = 100;
	private static int y = 100;
}

class Child extends Parent {
	public void print() {
		System.out.println("x= " + x);
		//System.out.println("y= " + y);
		System.out.println("x= " + Child.x);
		//System.out.println("y= " + Child.y);
	}
}