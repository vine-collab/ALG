package com.vine.concurrency.providerandconsumer;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author 阿季
 * @date 2023-09-06 8:52 AM
 */

public class BooleanLockTest {

    BooleanLock lock = new BooleanLock();

    public void syncMethod() {
        lock.lock();
        try {
            int random = current().nextInt(10);
            System.out.println(currentThread() + " get the lock");
            TimeUnit.SECONDS.sleep(random);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        BooleanLockTest test = new BooleanLockTest();
        IntStream.range(0, 10)
                .mapToObj(i -> new Thread(test::syncMethod))
                .forEach(Thread::start);
    }

}
