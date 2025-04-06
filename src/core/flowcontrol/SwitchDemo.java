package core.flowcontrol;

import static java.time.DayOfWeek.*;

import java.time.DayOfWeek;

public class SwitchDemo {
    public static void main(String[] args) {

        //classic switch statement
        int result;
        int value =2;
        switch (value) {
            case 1:
                result = 10;
                break;
            case 2:
                result = 20;
                break;
            default:
                result = 30;
        }

        System.out.println(result); //20

        //switch as an expression
        String result2 = switch (value) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "Unknown";
        };

        System.out.println(result2); //Two


        //multiple label in switch
        DayOfWeek day = FRIDAY;
        String result4 = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "Weekend vibes!";
            case TUESDAY, WEDNESDAY, THURSDAY -> "Midweek grind!";
            case SATURDAY -> "Party time!";
        };

        System.out.println(result4);  //Weekend vibes!


        //switch expression with yield
        int score = 8;
        String result3 = switch (score) {
            case 10 -> "Perfect!";
            case 9 -> "Excellent!";
            case 8 -> {
                System.out.println("Pretty good!");
                yield "Good job!";
            }
            default -> "Keep trying!";
        };

        System.out.println(result3);  //Good job!


        //Java 16
        //Pattern matching
        Object obj = "Hello, World!";
        String result5 = switch (obj) {
            case Integer i -> "Integer: " + i;  // Matches if obj is an Integer
            case String s -> "String: " + s;    // Matches if obj is a String
            default -> "Unknown type";
        };
        System.out.println(result5); //String: Hello, World!


    }
}
