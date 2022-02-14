package com.ling.test.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangling
 * @date 2022/1/18 4:35 下午
 */
public class AsyncDemo01 {

    public static void test01() {
        // 进行计算的线程池
        ExecutorService computeService = Executors.newFixedThreadPool(1);
        // 接收结果的线程池
        ExecutorService resultService = Executors.newFixedThreadPool(1);
        // log.debug("开始");
        CompletableFuture.supplyAsync(() -> {
            // log.debug("开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // log.debug("结束");
            return 10;
        }, computeService).thenAcceptAsync((result) -> {
            // log.debug("结果为:{}", result);
            System.out.println("result = " + result);
        }, resultService);
    }

    public static void main(String[] args) {
        test01();
    }
}
