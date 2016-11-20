package oo;

public class ReferencesInArguments {

	public static String staticString = "I am a Static string";
	
	public static void main(String[] args) {
		ReferencesInArguments a = new ReferencesInArguments();
		String str = "I am alive";
		a.messWithPointers(str);
		System.out.println(str);
		
		a.messWithPointers(staticString);
		System.out.println(staticString);
	}

	
	public void messWithPointers(String param){
		param = null;
	}
}
