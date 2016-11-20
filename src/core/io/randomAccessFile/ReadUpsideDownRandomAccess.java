package core.io.randomAccessFile;

import java.io.File;
import java.io.RandomAccessFile;

public class ReadUpsideDownRandomAccess {
	
	public static void main(String[] args) throws Exception {
		File f = new File("output/upsideDown.txt");
		RandomAccessFile randFile = new RandomAccessFile(f,"r");
		StringBuffer sbuf2 = new StringBuffer();
		for(long i=0;i<=f.length()-1;i++){
			//randFile.seek(i);
			sbuf2.append(randFile.readByte());
		}
		System.out.print(sbuf2.toString());
		randFile.close();

	}
}