package core.inner;

class MyOuter {
	private int x = 10;

	public void createLocalInnerClass(int a) {
		int y = 20;
		final int z = 30;
		class LocalInner {
			public void accessOuter() {
				System.out.println(a);
				System.out.println(x);
				System.out.println(y); 
				System.out.println(z);
			}
		}

		LocalInner li = new LocalInner();
		li.accessOuter();
	}
}

public class LocalClassTest {
	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		mo.createLocalInnerClass(1);
	}
}