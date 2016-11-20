package core.system;

public class CloneTest implements Cloneable {

	int x;
	String y;

	public static void main(String[] args) throws Exception {
		CloneTest t = new CloneTest();
		t.setX(3);
		t.setY("hello");

		CloneTest t2 = (CloneTest) t.clone();
		System.out.println(t == t2);
		System.out.println(t.getY() == t2.getY());
		t.setX(0);
		t.setY("there");
		
		System.out.println(t.getX());
		System.out.println(t2.getX());
		System.out.println(t.getY());
		System.out.println(t2.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

}
