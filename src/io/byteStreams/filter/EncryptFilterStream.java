package io.byteStreams.filter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class EncryptFilterStream {

	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("output/ciper.txt");
		StreamCipher cipherStream = new StreamCipher(out);
		for (int i = 65; i < 91; i++) {
			cipherStream.write(i);
		}

//                String s = "Hello World";
//                for(int i=0; i< s.getBytes().length; i++){
//                    cipherStream.write(s.getBytes()[i]);
//                }
		cipherStream.close();

		FileInputStream in = new FileInputStream("output/ciper.txt");
		StreamDeCipher cipherInStream = new StreamDeCipher(in);
		int byt;
		while ((byt = cipherInStream.read()) != -1) {
			System.out.print((char)byt);
		}
                System.out.println();
		cipherInStream.close();
	}
}

class StreamCipher extends FilterOutputStream {

	static byte[] cipherBitStream = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
			107, 109, 113, 127 };

	InputStream cipherStream = new CircularReadStream(cipherBitStream);

	public StreamCipher(OutputStream out) {
		super(out);
	}

	@Override
	public void write(int b) throws IOException {
		byte byt = (byte) (b ^ (cipherStream.read()));
		super.write(byt);
	}

}

class StreamDeCipher extends FilterInputStream {
	static byte[] cipherBitStream = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
			107, 109, 113, 127 };

	InputStream cipherStream = new CircularReadStream(cipherBitStream);

	public StreamDeCipher(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int val = super.read();
		if (val == -1) {
			return -1;
		}
		return (val ^ cipherStream.read());

	}
}