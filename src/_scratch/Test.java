package _scratch;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        new Test().add(1,2);
    }
        public void add(int param1, int... varArgs) {
            int sum = param1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1);
            for(int i: varArgs){
                sum = sum + i;
                stringBuilder.append("+"+i);
            }
            stringBuilder.append("="+sum);
    }
}



