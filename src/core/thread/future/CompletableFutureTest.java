package core.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by vasanth on 4/11/17.
 */
public class CompletableFutureTest {

    ExecutorService executorService=Executors.newCachedThreadPool();;
    public static void main(String[] args) throws  Exception{
        new CompletableFutureTest().execute();
    }

    private void execute() throws Exception{
        Future<String> future = calculateAsync();
        System.out.println(future.get());
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;
    }
}
