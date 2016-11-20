package core.printing;


public class PrintBytes {

	public static void main(String[] args) throws Exception {
		print("a".getBytes("UTF-8"));
		print("a".getBytes("UTF-16"));
	}

	public static void print(byte[] bytes) {
		System.out.println("number of bytes = " + bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02x \n", bytes[i]);
		}
	}
}
