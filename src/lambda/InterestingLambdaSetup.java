package lambda;

import java.io.IOException;
/*
 Lambda can be return value of a method, passed as argument o a method
 */
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return input -> input % 2 != 0;
    }

    PerformOperation isPrime() {
        return (input) -> {
            if (input <= 1) return false;
            if (input == 2) return true; // 2 is prime
            if (input % 2 == 0) return false; // even numbers >2 are not prime

            for (int i = 3; i <= Math.sqrt(input); i += 2) {
                if (input % i == 0) return false;
            }
            return true; // If no divisors found, it's prime
        };
    }

    PerformOperation isPalindrome() {
        return (input) -> {
            String str = String.valueOf(input);
            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
            }
            return true;
        };
    }
}

public class InterestingLambdaSetup {

    public static void main(String[] args) throws IOException {
        MyMath myMath = new MyMath();
        boolean ret;
        PerformOperation op;
        String ans = null;
        int ch = 1;
        int num = 505;
        // 1 for Odd/Even,
        // 2 for Prime,
        // 3 for Palindrome
        if (ch == 1) {
            op = myMath.isOdd();
            ret = myMath.checker(op, num);
            ans = (ret) ? "ODD" : "EVEN";
        } else if (ch == 2) {
            op = myMath.isPrime();
            ret = myMath.checker(op, num);
            ans = (ret) ? "PRIME" : "COMPOSITE";
        } else if (ch == 3) {
            op = myMath.isPalindrome();
            ret = myMath.checker(op, num);
            ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

        }
        System.out.println(ans);
    }
}
