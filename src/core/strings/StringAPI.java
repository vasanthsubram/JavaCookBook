package core.strings;

public class StringAPI {
	
	public static void main(String args[]){
		System.out.println("Hello.charAt(2) = "  + "Hello".charAt(2));		
		//1
		
		System.out.println("Hello.equals(World) = " + "Hello".equals("World"));	
		//false
		
		System.out.println("Hello.equals(hello) = " + "Hello".equals("hello"));	
		//false
		
		System.out.println("Hello.equalsIgnoreCase(hello) = " + "Hello".equalsIgnoreCase("hello"));	
		//true
		
		System.out.println("Hell.length() = " + "Hell".length());	
		//4
		
		//only char at the end-index is not part of the sub-string 
		System.out.println("HelloWorld".substring(1,5));	
		//ello
		  
		
		System.out.println("Hello World".indexOf("World"));	
		//6
		System.out.println("Hello World".indexOf("world"));	
		// -1
		
		System.out.println("Hello World".indexOf("World", 2));	
		//6
		System.out.println("Hello World".indexOf("World", 7));	
		//-1
		
		System.out.println("Hello World".toLowerCase());
		System.out.println("Hello World".toUpperCase());
		
		System.out.println(" Hello World ".trim());	
		//Hello World
		
		for(String s: ("Tom,Dick,Harry".split(","))){
			System.out.println(s);
		}
		//Tom
		//Dick
		//Harry
		
        
    	char c = 'A';
		if('a'<'b'){
			System.out.println("a < b is  " + true);
		}
		//a < b is  true
		
		System.out.println("Nnumeric value of \'8\'  is " +Character.getNumericValue('8'));
		//Nnumeric value of '8'  is 8
		
		System.out.println((int)'a');
		//97
		
		System.out.println('a');
		//a
		
		System.out.println("" + null + "  " + 'a');
		//null a
		
		System.out.println(new char[]{'a' ,'b'}); 
		//ab
		System.out.println(String.valueOf(new char[]{'a' ,'b'}));   
		//ab
		
		String letters = "ABC";
        char[] numbers = { '1', '2', '3' };
        System.out.println(letters + " easy as " + numbers);		//ABC easy as [C@3e25a5

        System.out.println(new String(new byte[]{65,66,67,68,69}));
        //ABCDE

		System.out.println(String.join(" ", "hello", "java", "world" ));
	}	
}
