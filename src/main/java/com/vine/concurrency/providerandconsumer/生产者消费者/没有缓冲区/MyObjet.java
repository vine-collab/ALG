package com.vine.concurrency.providerandconsumer.生产者消费者.没有缓冲区;

import java.awt.*;

/**
 * @author 阿季
 * @date 2023-09-04 11:14 PM
 */

public class MyObjet {

    int count = 0;

    public synchronized void consumer() {
        while (true) {
            if (count == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            count--;
            System.out.println("拿走一个：" + count);
            notify();
        }
    }


    public synchronized void producer() {
        while (true) {
            if(count > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            count--;
            System.out.println("加入一个：" + count);
            notifyAll();
        }
    }

}
