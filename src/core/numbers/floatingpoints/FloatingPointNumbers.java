package core.numbers.floatingpoints;

public class FloatingPointNumbers {
	public static void main(String args[]) {
		System.out.println((1.31e0 + 1.69e0) > (1.50e0 + 1.50e0));

		System.out.println("Double.NaN == Double.NaN  =>"
				+ (Double.NaN == Double.NaN));
		System.out.println("Double.NaN != Double.NaN  =>"
				+ (Double.NaN != Double.NaN));

		System.out.println("1.2f * Float.MAX_VALUE = "
				+ (1.2f * Float.MAX_VALUE));

		System.out.println("1f/0f = " + (1f / 0f));
		System.out.println("1f/0f is NaN ? = " + Float.isNaN(1f / 0f));
		System.out.println("0f/0f is NaN ? = " + Float.isNaN(0f / 0f));
	}
}
