package core.numbers.conversion.binary;

public class IntegerToBinaryString_BitShift {

	public static void main(String args[]) {
		for (byte i=0; i <= 127 && i>=0; i++) {
			System.out.println(i+ "\t" +toBinaryString(i));
		}
	}

	public static String toBinaryString(byte x) {
		StringBuffer buf = new StringBuffer();
		if (x >= 0) {
			for (int i = 1; i < 256; i = i * 2) {
				buf.append(((x & i) == 0) ? '0' : '1');
			}
			return buf.reverse().toString();
		} else {

		}
		return null;
	}
}
