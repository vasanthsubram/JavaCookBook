package core.basicJava;

/*
 when a variable member (including static members) of an object is accessed using a reference, 
 it is the type of the reference, not the class of the current object denoted by the 
 reference that determines which variable will actually be accessed. 
 This is reverse of the process that happens during method invocation.

 */
public class VariableShadowing{
	
	public static void main(String[] args) {
		ExtendShow ext = new ExtendShow();
		Show show=ext;
		System.out.println("show.str = " + show.str);
		System.out.println("ext.str = " + ext.str);
	}
}

class Show {
	public String str= "Str";
}

class ExtendShow extends Show{
	public String str= "ExtendStr";
}


