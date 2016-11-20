package core.strings.algorithms;

public class PasswordGenerator {

	private static int MAX = 127;
	private static int DEFAULT_PWD_SIZE = 8;

	public static void main(String args[]) {
		System.out.println(PasswordGenerator.generate());
		System.out.println(PasswordGenerator.generate(8));
	}

	public static String generate() {
		return PasswordGenerator.generate(DEFAULT_PWD_SIZE);
	}

	public static String generate(int maxSize) {
		StringBuffer buf = new StringBuffer(maxSize);
		int i = 0;
		while (buf.length() <= maxSize) {
			char c = (char) (Math.random() * MAX);

			if (32 < c && c < 127 && (buf.toString().indexOf(c) < 0)) {
				buf.insert(i, c);
				i++;
			}
		}
		return buf.toString();
	}
}
