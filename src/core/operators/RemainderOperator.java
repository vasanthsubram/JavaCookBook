package core.operators;

public class RemainderOperator {

	public static void main(String[] args) {

		//splitting an amount into integral and the fractional part
		double d = 100.23;
		long integral = new Double(d).longValue();
		int fractional = (int)((d * 100.0) % 100);
		
		System.out.println(integral);
		System.out.println(fractional);
	}

}
