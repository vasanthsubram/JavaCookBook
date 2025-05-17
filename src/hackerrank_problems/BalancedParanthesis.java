package hackerrank_problems;

import java.util.*;

/*
Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.
The part of the code that handles input operation is already provided in the editor.

Output Format
For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input
{}()
({()})
{}(
[]

Sample Output
true
true
false
true

 */
public class BalancedParanthesis{
    static Map<Character, Character> map = new HashMap<>();
    static Stack<Character> stack = new Stack();
    public static void main(String []argh) {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            boolean result = validate(sc.next());
            System.out.println(result);
            stack.clear();
        }
    }

    private static boolean validate(String input) {
        for(char c: input.toCharArray()){
            if (c=='{' || c=='[' || c=='('){
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char popped = stack.pop();
                if (map.get(popped)!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}

