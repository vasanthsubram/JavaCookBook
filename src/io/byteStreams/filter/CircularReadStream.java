package io.byteStreams.filter;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A filter stream that never runs out. When the underlying stream reaches the
 * end, this class resets it and begins again from the beginning.
 * 
 * This is useful for reading a fixed set of bytes, over and over
 * 
 * @author chq-vasanthakumars
 * 
 */
public class CircularReadStream  extends FilterInputStream{

	protected CircularReadStream(InputStream in) {
		super(in);
		mark(0);
	}

	public CircularReadStream(byte[] input) {
		this(new ByteArrayInputStream(input));
	}
	
	public int read() throws IOException{
		int val = super.read();
		if(val==-1){
			in.reset();
			val=super.read();
		}
		return val;
	}

	public static void main(String args[]) throws IOException{
		byte[] arr= {1,3,5,7,9,11};
		CircularReadStream circular= new CircularReadStream(arr);
		for(int i=0;i<20;i++){
			System.out.println(circular.read());
		}
	}
}
