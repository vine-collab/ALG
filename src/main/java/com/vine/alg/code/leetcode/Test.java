package com.vine.alg.code.leetcode;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author 阿季
 * @date 2022-05-01 10:55 AM
 */

public class Test {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(100);
        Task task = new Task(0, 100);
        Integer invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);
    }

}


class Task extends RecursiveTask<Integer> {


    private Integer limit = 2;

    private Integer startIndex;

    private Integer endIndex;

    public Task(Integer startIndex, Integer endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected Integer compute() {
        if (endIndex - startIndex <= limit) {
            int result = 0;
            System.out.println(Thread.currentThread().getName());
            for (int i = startIndex; i <= endIndex; i++) {
                result += i;
            }
            return result;
        } else {
            int middle = (startIndex + endIndex) / 2;
            Task taskLeft = new Task(startIndex, middle);
            Task taskRight = new Task(middle + 1, endIndex);
            invokeAll(taskLeft, taskRight);
            return taskLeft.join() + taskRight.join();
        }
    }
}



