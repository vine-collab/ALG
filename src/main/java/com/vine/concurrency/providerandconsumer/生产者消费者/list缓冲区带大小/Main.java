package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区带大小;

/**
 * @author 阿季
 * @date 2023-09-04 10:12 PM
 */

public class Main {

    public static void main(String[] args) {
        BlockList list = new BlockList(10);

        new Thread(new Consumer(list), "c1").start();
        new Thread(new Consumer(list), "c2").start();
//        new Thread(new Producer(list), "p1").start();
//        new Thread(new Producer(list), "p2").start();
//
//
//        new Thread(new Consumer(list), "c3").start();
//        new Thread(new Consumer(list), "c4").start();
//        new Thread(new Producer(list), "p3").start();
//        new Thread(new Producer(list), "p4").start();
    }

}
