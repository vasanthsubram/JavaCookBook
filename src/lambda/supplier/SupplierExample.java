package lambda.supplier;

import java.util.function.Supplier;

/**
 * Created by vasanthakumarsubramanian on 12/24/16.
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 42;
        System.out.println(supplier.get());

        Supplier<String> helloSupplier = () -> "Hello, World!";
        System.out.println(helloSupplier.get());
    }
}
