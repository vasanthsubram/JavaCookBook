package problems;

import java.math.BigDecimal;
import java.util.*;

/*
Given an array of  real number strings, sort them in descending order.
Each number must be printed in the exact same format as it was input .
If two numbers represent numerically equivalent values (e.g., ),
then they must be listed in the same order as they were received as input).
 */
public class SortBigDecimal2{
    public static void main(String []args){
        //Input
        String[] s= new String []{
                "-100",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000"
        };
        int n = s.length;

        //Write your code here
        class BigDecimalEntry {
            BigDecimal b;
            String str;
            BigDecimalEntry(BigDecimal b, String str) {
                this.b=b;
                this.str=str;
            }
        }

        BigDecimalEntry[] bigDArrray = new BigDecimalEntry[n];
        for(int i=0;i<n;i++) {
            bigDArrray[i] = new BigDecimalEntry(new BigDecimal(s[i]), s[i]);
        }
        Comparator<BigDecimalEntry> comparator = (b1, b2) -> b1.b.compareTo(b2.b);
        Arrays.sort(bigDArrray, comparator.reversed());

        for (int i=0;i<n;i++) {
            System.out.println(bigDArrray[i].str);
        }
    }
}