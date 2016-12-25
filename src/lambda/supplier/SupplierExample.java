package lambda.supplier;

import java.util.function.Supplier;

/**
 * Created by vasanthakumarsubramanian on 12/24/16.
 */
public class SupplierExample {

    static void display(Supplier<Integer> arg) {
        System.out.println(arg.get());
    }

    public static void main(String[] args) {

        // Pass lambdas to the display method.
        // ... These conform to the Supplier class.
        // ... Each returns an Integer.
        display(() -> 10);
        display(() -> 100);
        display(() -> (int) (Math.random() * 100));
    }
}
