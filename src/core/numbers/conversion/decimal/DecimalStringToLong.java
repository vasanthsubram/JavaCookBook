package core.numbers.conversion.decimal;

import static org.junit.Assert.assertEquals;
//Works for both positive and negative values
public class DecimalStringToLong {

	public static void main(String[] args) {
		String input1 = String.valueOf(Long.MIN_VALUE);
		long result = convert(input1);
		System.out.println("integer value is  " + result);
		assertEquals(Long.MIN_VALUE, result);
	}

	public static long convert(String input) {
		long result = 0;
		int start = (input.charAt(0) == '-') ? 0 : 1;

		for (int i = start; i < input.length(); i++) {
			result = (input.charAt(i) - '0') + (result * 10);
		}
		return (input.charAt(0) == '-') ? (0 - result) : result;
	}
}
