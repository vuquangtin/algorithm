package algorithm.miniapp.utils;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import algorithm.miniapp.sortassert.SortAssert;

/**
 * 全局线程池
 * @author Tao
 */
public class ThreadUtils {
    /**
     * 全局线程池 线程数量为系统核心数
     */
    private static ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    /**
     * 异步提交没有返回值的任务
     *
     * @param recursiveAction
     */
    public static void submitVoid(RecursiveAction recursiveAction){
        SortAssert.isNotNull(recursiveAction);
        forkJoinPool.execute(recursiveAction);
    }

    /**
     * 同步并阻塞提交没有返回值的任务
     *
     * @param recursiveAction
     */
    public static void executeVoid(RecursiveAction recursiveAction){
        SortAssert.isNotNull(recursiveAction);
        try {
            forkJoinPool.submit(recursiveAction).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步并阻塞提交有返回值的任务
     *
     * @param recursiveTask
     */
    public static<T> T executeTask(RecursiveTask<T> recursiveTask){
        SortAssert.isNotNull(recursiveTask);
        T data = null;
        try {
            data = forkJoinPool.submit(recursiveTask).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 线程睡眠 ms
     * @param ms
     */
    public static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            Thread.interrupted();
            e.printStackTrace();
        }
    }


    public static ForkJoinPool getForkJoinPool() {
        return forkJoinPool;
    }
}
