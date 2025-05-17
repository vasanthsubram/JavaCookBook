package core.thread.threadpools;

import utils.TestUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleUsingLamnda {

    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();

        for (int i = 0; i < 5; i++) {
            String word = TestUtils.getRandomString();
            Callable<Integer> callable =
                    () -> {
                        System.out.println(word);
                        return Integer.valueOf(word.length());
                    };
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.println();
        System.out.printf("The sum of lengths is %s%n", sum);
        pool.shutdownNow();
    }

}
