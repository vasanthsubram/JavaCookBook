package core.strings;

public class Java11StringFeatures {

    public static void main(String[] args) {

        System.out.println("   ".isBlank()); // true
        System.out.println("abc".isBlank()); // false

        String multiLine = "Line1\nLine2\nLine3";
        multiLine.lines().forEach(System.out::println);

        //Removes leading and trailing whitespace using Unicode-aware rules (unlike trim(), which only removes ASCII whitespace).
        System.out.println("  Hello World  ".strip()); // "Hello World"

        System.out.println("   Hello ".stripLeading()); // "Hello "
        System.out.println("   Hello ".stripTrailing()); // "   Hello"

        System.out.println("ha".repeat(3)); // "hahaha"
    }
}
