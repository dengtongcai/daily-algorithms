package me.datoucai.jdk.source;


import java.util.concurrent.*;

/**
 * CompletableFuture功能测试
 * CompletableFuture实现了线程返回值时候无需阻塞等待,而通过新开线程异步处理完成继续下一步执行
 *
 * @author cc
 * @date 2019/5/7
 */
public class MyCompletableFuture {
    private static final ExecutorService executor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());

    public static void main(String[] args) {
//        completableTest();

        completableTestPool(executor);

    }

    /**
     * 单线程异步回调处理
     */
    private static void completableTest() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> printNumber(6, 1));
        System.err.println(completableFuture.isDone());
        try {
            System.err.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 线程池异步回调
     *
     * @param executor
     */
    private static void completableTestPool(ExecutorService executor) {
        for (int i = 0; i < 10; i++) {
            final int a = i;
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> printNumber(6, a), executor);
            System.err.println(Thread.currentThread().getName() + " : " + i + " : " + completableFuture.isDone());
            try {
                System.err.println(Thread.currentThread().getName() + " : " + i + " : " + completableFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 线程打印返回结果
     *
     * @param x
     * @param thread
     * @return x
     */
    private static Integer printNumber(int x, int thread) {
        for (int i = 0; i < 2; i++) {
            x += i;
            System.out.println(Thread.currentThread().getName() + " : " + thread + " : " + i);
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }

    private void futureTest() {

    }

    private void completableAsyncTest() {

    }
}
