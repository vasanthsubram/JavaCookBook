package core.numbers.conversion.byteArray;

import static org.junit.Assert.assertEquals;
import java.util.Random;

public class BitShiftMethod {

	static Random rand = new Random();

	public static void main(String[] args) {
		int x = rand.nextInt();
		System.out.println("original int = \t\t" +x);
		byte[] bytes = intToByteArray(x);
		int reconstructedInt=byteArrayToInt(bytes);
		assertEquals(x, reconstructedInt);
		System.out.println("Reconstucted int =\t"+reconstructedInt);
	}

	public static byte[] intToByteArray(int x) {
		byte[] bytes = new byte[4];
		bytes[3] = (byte) ((x & 0xff000000) >> 24);
		bytes[2] = (byte) ((x & 0x00ff0000) >> 16);
		bytes[1] = (byte) ((x & 0x0000ff00) >> 8);
		bytes[0] = (byte) (x & 0x000000ff);
		return bytes;
	}

	public static int byteArrayToInt(byte[] bytes) {
		int x=0;
		x =x |((bytes[3] << 24) & (0xff000000));
		x =x |( (bytes[2] << 16) & (0x00ff0000));
		x =x |((bytes[1] << 8) & (0x0000ff00));
		x =x |(bytes[0] & 0x000000ff);
		return x;
	}
}
