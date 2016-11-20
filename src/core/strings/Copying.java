package core.strings;

public class Copying {
	public static void main(String[] args) throws Exception{
		
		//As of java 7 Two strings DO NOT share the internal char array, through a call to the substr method
		String str = "Hello World";
		String substr = str.substring(6, 11);
		StringUtil.printIdentityDetails(str, substr);
		
		System.out.println("=============");
		
		
		//Two strings share the internal char array, through a call to the constructor
		String s1 = new String("abc");
		String s2 = new String(s1);
		StringUtil.printIdentityDetails(s1, s2);

		System.out.println("=============");

        //copying using StringBuilder creates a completely unique String
        String s11 = "Hello World";
        String s22 = new StringBuilder(s11).toString();
        StringUtil.printIdentityDetails(s11, s22);
	}
	
	

}
