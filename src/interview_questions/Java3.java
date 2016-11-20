package interview_questions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Java3 implements Serializable{

	transient int x = 100;
	int y = 10;

	public static void main(String[] args) throws Exception {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
		ObjectOutputStream out = new ObjectOutputStream(bos) ;
	    out.writeObject(new Java3());
	    out.close();
	    
		
	    ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
	    Java3 obj = (Java3)in.readObject();
	    System.out.println(obj.x);
	    System.out.println(obj.y);
	}
}