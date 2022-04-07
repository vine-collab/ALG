package com.vine.concurrency.providerandconsumer;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 *
 * @author hekai
 * @create 2017-12-31-14:49
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    //随机对象
    private static Random r = new SecureRandom();

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(r.nextInt(1000));
                System.out.println("消费者:" + Thread.currentThread().getName() + ", 消费数据:" + this.queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
