import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiThreading {
static void mulTh() throws ExecutionException, InterruptedException {
    CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() ->
            {
           return  "Hello";});
/*
   * In Java’s CompletableFuture, both join() and get() are used to block
   *  until an asynchronous computation finishes and then retrieve its result. While their purpose is similar
   * , they differ mainly in exception handling and timeout support.*/
    CompletableFuture<String> stringCompletableFuture = completableFuture.thenCompose(CompletableFuture::completedFuture);
System.out.println(stringCompletableFuture.get());
/*
* In this blog, we learned how to chain tasks in CompletableFuture using:

thenApply() to transform the result.
thenCompose() to chain another asynchronous task.
thenRun() for performing side effects after the task completes.
* */
    stringCompletableFuture = completableFuture.thenCompose(s->{
        return CompletableFuture.supplyAsync(() -> "Priyanka==="+s);
    });
    System.out.println(stringCompletableFuture.get());

    System.out.println("ThenAccept");

    CompletableFuture<String> stringCompletableFuture1 =
            completableFuture.thenApply(s -> "Priya" + s);

    System.out.println("stringCompletableFuture1=="+stringCompletableFuture1.get());
}
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    mulTh();
    }

}
