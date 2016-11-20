package core.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author vsubramanian
 */
public class AccessingPrivateVariable {

    public static void main(String[] args) throws Exception {
        //'value' is a name of a variable in String
        //It is the array that stores the characters in a string.
        Field f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        String str = "Hello World";
        char[] arr= (char[])f.get(str);
        for(char c: arr){
            System.out.println(c);
        }
    }
}
