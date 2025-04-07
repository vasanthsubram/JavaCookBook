package core;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Java7Changes {

	public static void main(String[] args) {
		
		//64
		int binaryLiteral = 0b1000000;
		System.out.println(binaryLiteral);
		
		int phone = 125_100_2345;
		System.out.println(phone);
		
		//the files will be automatically closed
		//You can add multiple exceptions using the pipe
		 try (FileOutputStream fos = new FileOutputStream("file.txt");
	               DataOutputStream dos = new DataOutputStream(fos)) {
	         dos.writeUTF("test");
	           SimpleDateFormat ff=new SimpleDateFormat("MM-dd-yyyy");
	         ff.parse("2012-12-12");
	     } catch (IOException | ParseException e) {
	      }
		 //type inference
		 Map<String, String> anagrams = new HashMap<>();
		 
		 //switch
		 String s="Red";
		 switch(s){
		 	case "Red" :
		 		System.out.println("Red");
		 		break;
		 	case "Greens" :
		 		System.out.println("Green");
		 		break;
		 	case "Yellow": 
		 		System.out.println("Yellow");
		 		break;
		 }
	}

}
