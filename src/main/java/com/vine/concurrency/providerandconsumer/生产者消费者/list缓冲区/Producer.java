package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区;

import com.vine.concurrency.providerandconsumer.生产者消费者.Queue缓冲区.Provider;

import java.util.List;

/**
 * @author 阿季
 * @date 2023-09-04 10:07 PM
 */

public class Producer implements Runnable{


    private List<Object> list;


    public Producer(List<Object> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (list) {
                if(list.size() > 0) {
                    try {
//                        Thread.sleep(1000);
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Object o = new Object();
                list.add(o);
                System.out.println(Thread.currentThread().getName() + "加入一个, 当前个数：" + list.size());
                list.notifyAll();
            }
        }

    }
}
