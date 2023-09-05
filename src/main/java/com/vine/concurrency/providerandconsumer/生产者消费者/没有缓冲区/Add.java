package com.vine.concurrency.providerandconsumer.生产者消费者.没有缓冲区;

import com.vine.concurrency.providerandconsumer.sync.MyObject;

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
        obj.add();
    }
}
