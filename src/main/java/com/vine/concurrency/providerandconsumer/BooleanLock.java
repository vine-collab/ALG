package com.vine.concurrency.providerandconsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.currentThread;

/**
 * @author 阿季
 * @date 2023-09-06 8:31 AM
 */

public class BooleanLock {

    private Thread currentThread;
    private boolean locked = false;
    private final List<Thread> blockedList = new ArrayList<>();


    public void lock() {
        synchronized (this) {
            while (locked) {
                Thread tmpThread = currentThread();
                try {
                    if (!blockedList.contains(tmpThread)) {
                        blockedList.add(tmpThread);
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    blockedList.remove(tmpThread);
                    throw new RuntimeException(e);
                }
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    public void lock(long mills) throws Exception {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainMills = mills;
                long endMills = System.currentTimeMillis() + remainMills;
                while (locked) {
                    if (remainMills <= 0) throw new RuntimeException("can not get the lock during " + mills);
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    this.wait(remainMills);
                    remainMills = endMills - System.currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.")
                        .ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }

}











