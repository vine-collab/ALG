package com.vine.concurrency.providerandconsumer.sync;

/**
 * @author 阿季
 * @date 2023-09-03 9:39 PM
 */

public class Test {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Add add = new Add(myObject);
        Remove remove = new Remove(myObject);
        new Thread(add).start();
        new Thread(remove).start();
        new Thread(add).start();
        new Thread(remove).start();

    }
}
