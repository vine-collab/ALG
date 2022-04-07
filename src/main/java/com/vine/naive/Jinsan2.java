package com.vine.naive;

public class Jinsan2 {

    static int i = 0;
    static Object lock = new Object();
    static boolean flag1 = true, flag2 = true, flag3 = true;

    public static void main(String args[]) {

	Thread a = new Thread("a") {
        @Override
	    public void run() {
		for (;;) {
		    synchronized (lock) {
			while (!flag1 || !flag2) {		// 可以过时，应 while
			    System.out.println(Thread.currentThread().getName()
				    + " wait");
			    try {
				lock.wait();
			    } catch (InterruptedException e) {
			    }
			}
			System.out.println(Thread.currentThread().getName()+" "+i++ + " ");
			flag2 = !flag2;
			lock.notifyAll();
		    }
		}
	    }
	};
	Thread b = new Thread("b") {
	    @Override
	    public void run() {
		for (;;) {
		    synchronized (lock) {
			while (!flag1 || flag2) {
			    System.out.println(Thread.currentThread().getName()
				    + " wait");
			    try {
				lock.wait();
			    } catch (InterruptedException e) {
			    }
			}
			System.out.println(Thread.currentThread().getName()+" "+i++ + " ");
			flag1 = false;
			flag2 = !flag2;
			lock.notifyAll();
		    }
		}
	    }
	};
	Thread c = new Thread("c") {
	    @Override
	    public void run() {
		for (;;) {
		    synchronized (lock) {
			while (flag1 || !flag2) {
			    System.out.println(Thread.currentThread().getName()
				    + " wait");
			    try {
				lock.wait();
			    } catch (InterruptedException e) {
			    }
			}
			System.out.println(Thread.currentThread().getName()+" "+i-- + " ");
			flag2 = !flag2;
			lock.notifyAll();
		    }
		}
	    }
	};
	Thread d = new Thread("d") {
	    @Override
	    public void run() {
		for (;;) {
		    synchronized (lock) {
			while (flag1 || flag2) {
			    System.out.println(Thread.currentThread().getName()
				    + " wait");
			    try {
				lock.wait();
			    } catch (InterruptedException e) {
			    }
			}
			System.out.println(Thread.currentThread().getName()+" "+i-- + " ");
			flag1 = true;
			flag2 = !flag2;
			lock.notifyAll();
		    }
		}
	    }
	};
	a.start();
	b.start();
	c.start();
	d.start();
    }
}
