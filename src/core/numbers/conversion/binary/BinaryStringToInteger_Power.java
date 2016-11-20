package core.numbers.conversion.binary;
/**
Program that converts a string containing binary to integers.
The program fails at and after 64 1s 
*/

public class BinaryStringToInteger_Power {

	public static void main(String[] args) {
		String input = "1111";
		long result = 0L;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1') {
				result += powerOf(input.length() - i - 1);
			}
		}
		System.out.println("integer value of " + input + " is = " + result);
	}

	static long powerOf(int n) {
		if (n == 0)
			return 1L;

		long prod = 1L;
		for (int i = 0; i < n; i++) {
			prod *= 2L;
		}
		return prod;
	}
}
