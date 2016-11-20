package core.numbers.conversion.byteArray;

import java.nio.ByteBuffer;
import java.util.Random;

public class ByteBufferMethod {

	static Random rand = new Random();

	public static void main(String[] args) {
		int x = rand.nextInt();
		System.out.println("original number = " + x);
		byte[] bytes = inToBytes(x);
		for (byte b : bytes) {
			System.out.print(b);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println(bytesToInt(bytes));
	}

	static byte[] inToBytes(int i) {
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(i);
		return bb.array();
	}

	static int bytesToInt(byte[] intBytes) {
		ByteBuffer bb = ByteBuffer.wrap(intBytes);
		return bb.getInt();
	}
}
