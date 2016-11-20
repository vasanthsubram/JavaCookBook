package core.strings;

public class StringAndNull {

		public static void main(String[] args) {
			
			String s = "Hello";
						
			try{
				s.concat(null);
			} catch(NullPointerException ex){
				ex.printStackTrace();
			}
			
			//passing a null does not break the code
			System.out.println(s + null);
			System.out.println(s.equals(null));
		}
}
