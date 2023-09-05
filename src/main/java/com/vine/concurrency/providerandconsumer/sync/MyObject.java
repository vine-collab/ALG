package com.vine.concurrency.providerandconsumer.sync;

public class MyObject {


    int count = 0;

    public synchronized void add() {
        if(count != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        count++;
        System.out.println(count);
        notifyAll();
    }


    public synchronized void remove() {
        if(count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        count--;
        System.out.println(count);
        notifyAll();

    }

}
