package io.serialization.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import utils.Employee;


public class SerializingObject {

	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		out.writeObject(harry);

		byte[] buf = bos.toByteArray();

		System.out.println("Magic word");
		System.out.print(Integer.toHexString(0xFF & buf[0]));
		System.out.print(Integer.toHexString(0xFF & buf[1]));
		System.out.println();

		System.out.println("Version number of object serialization format");
		System.out.print(Integer.toHexString(0xFF & buf[2]));
		System.out.print(Integer.toHexString(0xFF & buf[3]));
		System.out.println();

		System.out.println("Indicating Object");
		System.out.print(Integer.toHexString(0xFF & buf[4]));
		System.out.println();

		System.out.println("Indicating Class name length");
		System.out.print(Integer.toHexString(0xFF & buf[5]));
		System.out.print(Integer.toHexString(0xFF & buf[6]));
		System.out.println();

		System.out.println("Object itself");
		for (int i = 7; i < buf.length; i++)
			System.out.print((char) buf[i]);
			//System.out.print(Integer.toHexString(0xFF & buf[i]));
	}
}
