package core.io.serialization.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializingString {

	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject("Hello");
		out.close();

		byte[] buf = bos.toByteArray();
		
		System.out.println("Magic word");
		System.out.print(Integer.toHexString(0xFF & buf[0]));
		System.out.print(Integer.toHexString(0xFF & buf[1]));
		System.out.println();
		
		System.out.println("Version number of object serialization format");
//		/System.out.println(Integer.parseInt(new String(b)));
		System.out.print(Integer.toHexString(0xFF & buf[2]));
		System.out.print(Integer.toHexString(0xFF & buf[3]));
		System.out.println();
		
		System.out.println("Indicating string");
		System.out.print(Integer.toHexString(0xFF & buf[4]));
		System.out.println();
		
		System.out.println("Indicating string length");
		System.out.print(Integer.toHexString(0xFF & buf[5]));
		System.out.print(Integer.toHexString(0xFF & buf[6]));
		System.out.println();
		
		System.out.println("Characters of the string");
		for (int i = 7; i < buf.length; i++)
			System.out.print((char) buf[i]);
		}
}
