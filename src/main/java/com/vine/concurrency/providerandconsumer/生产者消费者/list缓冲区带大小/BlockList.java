package com.vine.concurrency.providerandconsumer.生产者消费者.list缓冲区带大小;

import javax.crypto.Cipher;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 阿季
 * @date 2023-09-04 10:45 PM
 */

public class BlockList {

    private LinkedList<Object> list;


    int capacity;

    public BlockList(int capacity) {
        list = new LinkedList<>();
    }


    public void add() {
        synchronized (list) {
            if(list.size() >= capacity) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            list.addLast(new Object());
            System.out.println(Thread.currentThread().getName() + "加入一个, 当前个数：" + list.size());
            list.notifyAll();
        }

    }


    public void remove() {
        synchronized (list) {
            if(list.size() == 0) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            list.removeFirst();
            System.out.println(Thread.currentThread().getName() + "拿走一个, 剩余个数：" + list.size());
            list.notifyAll();
        }



    }


}
