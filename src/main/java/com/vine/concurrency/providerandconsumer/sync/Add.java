package com.vine.concurrency.providerandconsumer.sync;

/**
 * @author 阿季
 * @date 2023-09-03 9:37 PM
 */

public class Add implements Runnable {

    private MyObject obj;

    public Add(MyObject obj) {
        this.obj = obj;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            obj.add();
        }
    }
}
