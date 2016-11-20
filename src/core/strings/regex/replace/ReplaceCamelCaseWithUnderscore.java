package core.strings.regex.replace;

import java.util.regex.Pattern;

public class ReplaceCamelCaseWithUnderscore {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("([A-Z])");
        System.out.println(p.matcher("startDate").replaceAll("_$1").toLowerCase());
        System.out.println(p.matcher("customerBillingAccount").replaceAll("_$1").toLowerCase());
    }
}
