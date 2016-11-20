package core.numbers.bigNumbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimals {

	public static void main(String args[]) {
		// use string as argument to BigDecimal constructors
		System.out.println(new BigDecimal(1234.4164));
		System.out.println(new BigDecimal("1234.4164"));

		BigDecimal bigD = new BigDecimal(String.valueOf(1234.4164));
		BigDecimal bigD2 = new BigDecimal(String.valueOf(1234.4164));
		System.out.println(bigD.add(bigD2));
		System.out.println(bigD.add(bigD2).setScale(2, RoundingMode.HALF_UP)
				.toString());
		System.out.println(bigD.add(bigD2).setScale(4, RoundingMode.HALF_UP)
				.toString());

		// Always use a rounding option in division; otherwise it may throw an
		// exception
		BigDecimal d1 = new BigDecimal("13523.34");
		BigDecimal d2 = new BigDecimal("123.34");
		// System.out.println(d1.divide(d2);
		System.out.println(d1.divide(d2, BigDecimal.ROUND_DOWN));

		BigDecimal test = new BigDecimal("20.9");
		System.out.println(test.floatValue());
	}

}
