package core.io.byteStreams.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class RWBinaryDataIOStream {

	public static void main(String arg[]) throws Exception {
		Random ran = new Random();
		int MAX=10;
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"output/numerical.dat"));

		for (int i = 0; i < MAX; i++) {
			out.writeInt(i);
			out.writeDouble(ran.nextDouble());
		}
		out.close();
		
		
		DataInputStream in = new DataInputStream(new FileInputStream(
				"output/numerical.dat"));

		for (int i = 0; i < MAX; i++) {
			System.out.println(in.readInt());
			System.out.println(in.readDouble());
		}
		in.close();
	}
}