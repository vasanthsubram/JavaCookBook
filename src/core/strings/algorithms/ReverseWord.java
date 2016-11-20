package core.strings.algorithms;

import java.util.Stack;

public class ReverseWord {

    public static void main(String[] args) {

        String original = "Originals";

       System.out.println("loop");
        for (int i = original.length() - 1; i >= 0; i--) {
            System.out.print(original.charAt(i));
        }
        System.out.println("\n");

        
       System.out.println("loop - in place");
        char[] chars = original.toCharArray();
        int len=chars.length;

         for (int i = 0, j=len-1; (i < len/2); i++, j--) {
            char c = original.charAt(i);
            chars[i]=chars[j];
            chars[j]=c;
        }
        System.out.println(new String(chars));
        System.out.println();
        

       System.out.println("using stack");
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }
        for (int i = 0; i < original.length(); i++) {
            System.out.print(stack.pop());
        }

         System.out.println();
    }
}
