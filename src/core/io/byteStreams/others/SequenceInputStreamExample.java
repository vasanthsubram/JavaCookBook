package core.io.byteStreams.others;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class SequenceInputStreamExample {

	public static void main(String[] args) throws Exception {
		
		List<InputStream> inputs = new ArrayList<InputStream>();
		inputs.add(new FileInputStream("output/file-chain1.txt"));
		inputs.add(new FileInputStream("output/file-chain2.txt"));

		Enumeration<InputStream> files = Collections.enumeration(inputs);
		
		InputStream in = new SequenceInputStream(files);
		
		int ch;
		while((ch=in.read()) != -1){
			System.out.print((char)ch);
		}
		in.close();
	}

}
