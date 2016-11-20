package core.strings;

import java.lang.reflect.Field;

public class StringUtil {

	public static char[] getCharArray(String s) {
		try {
			Field f = s.getClass().getDeclaredField("value");
			f.setAccessible(true);
			return (char[]) f.get(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

        static public void printIdentityDetails(String str1, String str2) throws Exception{
		System.out.print("1st string  = ");
		System.out.println(str1);
		System.out.print("2nd  string  =  ");
		System.out.println(str2);

		System.out.println("Is str1 == str2 ?  " + (str1==str2));
		Field f = str1.getClass().getDeclaredField("value");
		f.setAccessible(true);

		System.out.println();

		System.out.println("Are internal arrays the same object ?  " + (f.get(str1)==f.get(str2)));

		System.out.println();

		System.out.print("1st  string's internal array  = ");
		for(char c: (char[])f.get(str1)){
			System.out.print(c);
		}
		System.out.println();
		System.out.print("2nd string internal array  =  ");
		for(char c: (char[])f.get(str2)){
			System.out.print(c);
		}
		System.out.println();
		System.out.println("hash for 1st string's array  = " + f.get(str1).hashCode());
		System.out.println("hash for 2nd string's array  = " + f.get(str2).hashCode());

	}
}
