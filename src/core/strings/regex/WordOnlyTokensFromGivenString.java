package core.strings.regex;

import java.util.Arrays;
import java.util.List;

public class WordOnlyTokensFromGivenString {
    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        String[] tokens = s.trim().split("[^A-Za-z]+");
        List list = Arrays.asList(tokens);
        list.forEach(System.out::println);
    }
}
