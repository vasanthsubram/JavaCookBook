package io.byteStreams.basic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOuputStreamExample {

	public static void main(String[] args) throws IOException {
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (int i = 65; i < 75; i++) {
			bos.write(i);
		}
		System.out.println(new String (bos.toByteArray()));
		
		bos.reset();
		
		bos.write(new byte[]{72,69,76,80});
		System.out.println(new String(bos.toByteArray()));
		bos.close();
	}
}
