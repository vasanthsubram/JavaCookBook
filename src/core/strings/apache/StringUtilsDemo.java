package core.strings.apache;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author vsubramanian
 */
public class StringUtilsDemo {

    public static void main(String[] args) {
        String s = "Hello", s2="", s3=null;
        
        System.out.println(StringUtils.defaultIfEmpty(s, "World"));
        
        //return 2nd param if ist param is empty
        System.out.println(StringUtils.defaultIfEmpty(s2, "World"));
        
        //return 2nd param if ist param is null
        System.out.println(StringUtils.defaultString(s3, "default"));

        //return empty string if the argument is null; otherwise return param
        System.out.println(StringUtils.defaultString(s));
        System.out.println(StringUtils.defaultString(s3));
        
        System.out.println(StringUtils.join(new Object[]{"Hello", "World"}));

        List<String> strings = Arrays.asList("Gold", "Silver", "Copper");
        System.out.println(StringUtils.join(strings.iterator(), ", "));

        System.out.println(StringUtils.leftPad(s, 10));
        System.out.println(StringUtils.rightPad(s, 10, '.'));

        System.out.println(StringUtils.swapCase("Hello World"));

        for (String str : StringUtils.split("Hello  Hello  World", " ")) {
			System.out.println(str);
	}

        //trim and if the result is empty, return null
        System.out.println(StringUtils.trimToNull("  "));

        //trim and if the result is empty, return empty string
        System.out.println(StringUtils.trimToEmpty(" "));
    }
}
