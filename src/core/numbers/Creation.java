package core.numbers;

import org.apache.xpath.operations.Bool;

import java.math.BigInteger;

public class Creation {
    public static void main(String[] args) {
        Character c1 = Character.valueOf('c');
        Boolean bool = Boolean.valueOf(true);
        Integer integer1 = Integer.valueOf(200);


        Boolean bool2 = Boolean.valueOf("true");
        Integer integer2 =  Integer.valueOf("200");

        //Converting wrapper instances to string representations
        String s = c1.toString();

        //Converting wrapper instances to primitives
        char c = c1.charValue();
        boolean b = bool.booleanValue();
        int val = integer1.intValue();


        byte val1 = Byte.parseByte("16");
        int intVal = Integer.parseInt("42");

        BigInteger bigInteger = new BigInteger("100000000000");


    }
}
