package com.hoteach.concurrency.providerandconsumer;

import java.util.concurrent.*;

/**
 * @author hekai
 * @create 2017-12-31-15:04
 */
public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Provider provider1 = new Provider(queue);
        Provider provider2 = new Provider(queue);
        Provider provider3 = new Provider(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService cachePool = Executors.newCachedThreadPool();
        cachePool.execute(provider1);
        cachePool.execute(provider2);
        cachePool.execute(provider3);
        cachePool.execute(consumer1);
        cachePool.execute(consumer2);
        cachePool.execute(consumer3);

    }

}
