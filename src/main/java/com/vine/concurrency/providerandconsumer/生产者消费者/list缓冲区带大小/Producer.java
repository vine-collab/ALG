package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区带大小;

/**
 * @author 阿季
 * @date 2023-09-04 10:07 PM
 */

public class Producer implements Runnable {


    private BlockList list;


    public Producer(BlockList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            list.add();
        }
    }

}
