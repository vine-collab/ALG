package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区;

import java.util.List;

/**
 * @author 阿季
 * @date 2023-09-04 10:08 PM
 */

public class Consumer implements Runnable {

    private List<Object> list;


    public Consumer(List<Object> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
//                        Thread.sleep(1000);
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                list.remove(0);
                System.out.println(Thread.currentThread().getName() + "拿走一个, 剩余个数：" + list.size());
                list.notifyAll();
            }
        }
    }
}
