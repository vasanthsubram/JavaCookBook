package _scratch;


import hibernate.mappings.collection_valued_uni_directional_one_to_many.Shipment;

import java.util.Arrays;
import java.util.List;

public class Scratch1 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
//        System.out.println(isAnagram("TestTest","testsest"));

       String[] arr = "He is a very very good boy, isn't he?".split("[^A-Za-z]" );
        System.out.println(arr);
        List list = Arrays.asList(arr);
        list.forEach(System.out::println);


        String s = new String(new char[5]);
        System.out.println(s);
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function

        String str1 = a.toUpperCase();
        String str2 = b.toUpperCase();

        if (str1.equals(str2)) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i=0;i<str1.length(); i++){
            int c = (int)(str1.charAt(i)) - (int)'A';
            count1[c] = count1[c]+1;
        }

        for (int i=0;i<str2.length(); i++){
            int c = (int)(str2.charAt(i)) - (int)'A';
            count2[c] = count2[c]+1;
        }

        for (int i=0;i<str1.length(); i++){
            System.out.println("Count 1 = " + count1[i] + " --> " + "Count 2 = " + count2[i]);
            if (count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}

