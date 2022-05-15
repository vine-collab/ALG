package com.vine.alg.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个读者多个写这一个缓冲区
 *
 * @author hekai
 * @create 2017-12-19-21:58
 */
public class ReadersAndWritersOperateSingleBuffer {

    /*评测题目: 编程模拟实现并发读写，写线程和读线程共享一个整数变量a，
    初始化值a=0，写线程有3个，读线程有10个。写线程每隔1分钟，对a的值进行一次递增加1操作；
    每个读线程每100毫秒读取一次a当前的数值，并且打印出来。要求尽量考虑程序整体的性能最优，同时不允许出现脏读幻读。*/

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private static volatile int value = 0;

    public void handleRead() {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + "开始读操作");
            TimeUnit.MILLISECONDS.sleep(100L);
            System.out.println(Thread.currentThread().getName() + "读操作value:" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }


    public void handleWrite() {
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + "写操作");
            value += 1;
            TimeUnit.SECONDS.sleep(1L);
            System.out.println(Thread.currentThread().getName() + "写完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadersAndWritersOperateSingleBuffer test = new ReadersAndWritersOperateSingleBuffer();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                    test.handleWrite();

            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                    test.handleRead();

            }).start();
        }




    }

}




























