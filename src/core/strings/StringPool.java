package core.strings;

import java.util.ArrayList;

public class StringPool {

	private static ArrayList<StringBuffer> bufferPool = new ArrayList<StringBuffer>(1);
	
	public static synchronized StringBuffer retreiveBuffer(){
		if(bufferPool.size()==0){
			bufferPool.add(new StringBuffer());
		}
		StringBuffer buf =bufferPool.remove(0);
		clear(buf);
		return buf;	
	}
	
	
	public static synchronized void returnBuffer(StringBuffer buf){
		bufferPool.add(buf);
	}
	
	public static void main(String[] args) {
		StringBuffer buf=StringPool.retreiveBuffer();
		for(int i=0;i<10;i++)
		buf.append('x');
		System.out.println(buf.toString());
		StringPool.returnBuffer(buf);
		
		StringBuffer buf2=StringPool.retreiveBuffer();
		buf.append('x');
		System.out.println(buf2.toString());
		
		char[] c= new char[0];
		System.out.println(c);
	}
	
	private static void clear(StringBuffer buf){
		for(int i=0;i<buf.length();i++){
			buf.setCharAt(i, '\u0000');
		}
	}

}
