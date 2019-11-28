package me.datoucai.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * MapReduce
 *
 * @author dengtongcai
 * @date 2019-11-28 10:56 上午
 * @email dengtongcai@xueqiu.com
 **/
public class ForkJoinCalculator extends RecursiveTask<Integer> {

    private int start, end;
    private static final int threshold = 20;

    public ForkJoinCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            int mid = (end - start) / 2;
            ForkJoinCalculator task1 = new ForkJoinCalculator(start, mid);
            ForkJoinCalculator task2 = new ForkJoinCalculator(mid + 1, end);
            invokeAll(task1, task2);
            Integer join1 = task1.join();
            Integer join2 = task2.join();
            sum = join1 + join2;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculator task = new ForkJoinCalculator(1, 30);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
