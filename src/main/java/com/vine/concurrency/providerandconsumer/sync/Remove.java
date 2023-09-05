package com.vine.concurrency.providerandconsumer.sync;

/**
 * @author 阿季
 * @date 2023-09-03 9:37 PM
 */

public class Remove implements Runnable {

    private MyObject obj;

    public Remove(MyObject obj) {
        this.obj = obj;
    }


    @Override
    public void run() {
            obj.remove();
    }
}
