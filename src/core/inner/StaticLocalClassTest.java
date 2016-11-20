package core.inner;

class MyStaticOuter {
	private int x = 10;
	private static int xx=100;
	public static void createLocalInnerClass(int a) {
		int y = 20;
		final int z = 30;
		class LocalInner {
			public void accessOuter() {
				System.out.println(a);
//				System.out.println(x);
				System.out.println(y); 
				System.out.println(z);
				System.out.println(xx);
			}
		}

		LocalInner li = new LocalInner();
		li.accessOuter();
	}
}

public class StaticLocalClassTest {
	public static void main(String[] args) {
		MyStaticOuter mo = new MyStaticOuter();
		mo.createLocalInnerClass(1);
	}
}
