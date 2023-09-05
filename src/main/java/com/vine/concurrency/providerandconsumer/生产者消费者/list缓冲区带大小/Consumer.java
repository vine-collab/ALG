package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区带大小;

import java.util.List;

/**
 * @author 阿季
 * @date 2023-09-04 10:08 PM
 */

public class Consumer implements Runnable {

    private BlockList list;


    public Consumer(BlockList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove();
        }
    }
}
