package lambda;

public class CompareInterfaceAndFunctionalInterface {

    @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

    //regular interface
    interface Greeting2 {
        void sayHello(String name);
    }

    public static void main(String[] args) {

        //---------functional interface
        Greeting g = name -> System.out.println("Hello " + name); // collection_lambda.collection.lambda
        g.sayHello("Alice - collection_lambda.collection.lambda");


        //-------regular interface
        Greeting2 g2 = new Greeting2() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };

        g2.sayHello("Alice-Innerclass");
    }
}
