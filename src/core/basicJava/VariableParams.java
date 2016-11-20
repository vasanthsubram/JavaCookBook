package core.basicJava;

/**
 *
 * @author vsubramanian
 */
public class VariableParams {

    public static void main(String[] args) {
        new VariableParams().test(1);
         new VariableParams().test(1,2);
          new VariableParams().test(1,2,3);
          new VariableParams().test();
    }

    public void test(int... ints){
        int sum=0;
        for(int i: ints){
            sum+=i;
        }
        System.out.println(ints.length + " " + sum + "  ");
    }
}
