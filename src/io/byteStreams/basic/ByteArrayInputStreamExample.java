package io.byteStreams.basic;

import java.io. *;

public class ByteArrayInputStreamExample {
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74 };
	
		int byt;
		ByteArrayInputStream bis = new ByteArrayInputStream(buffer);

		while ((byt = bis.read()) != -1) {
			System.out.println((char) byt);
		}
		bis.reset();

		byte[] dest=new byte[buffer.length];
		//copy internal array into the dest array 
		bis.read(dest);
		bis.close();
		
		System.out.println(new String(dest));
	}
}
