import java.util.Date;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future demo = new Future();
        ExecutorService executors = Executors.newFixedThreadPool(4);
        Long start = System.currentTimeMillis();
        java.util.concurrent.Future<Integer> f1 = executors.submit(() -> demo.processTask(2));
        java.util.concurrent.Future<Integer> f2 = executors.submit(() -> demo.processTask(3));
        java.util.concurrent.Future<Integer> f3 = executors.submit(() -> demo.processTask(4));
        java.util.concurrent.Future<Integer> f4 = executors.submit(() -> demo.processTask(4));
        java.util.concurrent.Future<Integer> f5 = executors.submit(() -> demo.processTask(3));
        java.util.concurrent.Future<Integer> f6 = executors.submit(() -> demo.processTask(2));
        java.util.concurrent.Future<Integer> f7 = executors.submit(() -> demo.processTask(5));
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
        System.out.println(f6.get());
        System.out.println(f7.get());

//        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(2);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(3);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(4);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(4);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf5 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(3);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf6 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(2);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Integer> cf7 = CompletableFuture.supplyAsync(() -> {
//            try {
//                return demo.processTask(5);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }, executors);
//        CompletableFuture<Void> combined = CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5, cf6, cf7);
//        combined.get();
//        System.out.println(cf1.get());
//        System.out.println(cf2.get());
//        System.out.println(cf3.get());
//        System.out.println(cf4.get());
//        System.out.println(cf5.get());
//        System.out.println(cf6.get());
//        System.out.println(cf7.get());
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        executors.shutdown();
    }

    private Integer processTask(int time) throws Exception{
        Thread.sleep(time*1000);
        System.out.println("Done task");
        return 1;
    }
}
