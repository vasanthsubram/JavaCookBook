package core.character;


public class UTF_8CharacterEncoding {

	public static void main(String[] args) throws Exception {

		System.out.println("Letter a");
		print("a".getBytes("UTF-8"));
		print("a".getBytes("UTF-16"));
		
		System.out.println("\na Greek letter");
		print("\u0370".getBytes("UTF-8"));
		print("\u0370".getBytes("UTF-16"));
		
		System.out.println("\na tamil letter");
		print("\u0B80".getBytes("UTF-8"));
	}

	private static void print(byte[] bytes) {
		System.out.println("number of bytes = " + bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			System.out.format("%02x \n", bytes[i]);
		}
	}
}
