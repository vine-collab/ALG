package com.vine.threalocal;

import java.lang.reflect.Field;

public class ThreadLocalDemo {


    static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        Thread t = new Thread(() -> test("abc", false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", false));
        t2.start();
        t2.join();

        System.out.println("12312321312");
    }

    private static void test(String s, boolean isGC) {
        try {
//            threadLocal
//            new ThreadLocal<>().set(s);
            threadLocal.set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            int i = 0;
            for (Object o : arr) {
                i++;
                if (o != null) {
                    System.out.println(i);
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
            System.out.println("---" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
