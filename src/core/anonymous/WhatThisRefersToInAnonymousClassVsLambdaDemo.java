package core.anonymous;

public class WhatThisRefersToInAnonymousClassVsLambdaDemo {

    public static void main(String[] args) {
        new WhatThisRefersToInAnonymousClassVsLambdaDemo().test();
    }

    public void test() {
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Anonymous");
                System.out.println(this.getClass());  // refers to the anonymous class
            }
        };
        r1.run();

        Runnable r2 = () -> {
            System.out.println("Lambda");
            System.out.println(this.getClass());     // refers to Demo class
        };
        r2.run();
    }
}
