package com.hoteach.concurrencyproviderandconsumer;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 *
 * @author hekai
 * @create 2017-12-31-14:57
 */
public class Provider implements Runnable {

    private BlockingQueue<Integer> queue;

    private AtomicInteger data = new AtomicInteger();

    private Random r = new SecureRandom();

    public Provider(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(r.nextInt(1000));
                int data = this.data.incrementAndGet();
                System.out.println("当前线程:" + Thread.currentThread().getName() + ", 获取了数据，data为:" + data + ", 进行装载到公共缓冲区中...");
                if(!this.queue.offer(data, 2, TimeUnit.SECONDS)){
                    System.out.println("提交缓冲区数据失败....");
                    //do something... 比如重新提交
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




















