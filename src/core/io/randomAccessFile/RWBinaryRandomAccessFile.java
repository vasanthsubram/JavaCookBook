package core.io.randomAccessFile;

import java.io.RandomAccessFile;
import java.util.*;

public class RWBinaryRandomAccessFile {

	public static void main(String arg[]) throws Exception {
		Random ran = new Random();
		int MAX = 15;

		RandomAccessFile out = new RandomAccessFile("output/numerical.txt",
				"rw");

		for (int i = 0; i < MAX; i++) {
			out.writeInt(i);
			out.writeDouble(ran.nextDouble());
		}
		out.close();

		
		RandomAccessFile in = new RandomAccessFile("output/numerical.txt",
				"r");
		for (int i = 0; i < MAX; i++) {
			System.out.println(in.readInt());
			System.out.println(in.readDouble());

		}
		in.close();
	}
}