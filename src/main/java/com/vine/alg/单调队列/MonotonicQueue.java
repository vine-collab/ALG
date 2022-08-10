package com.vine.alg.单调队列;

import java.util.LinkedList;

/**
 * @author 阿季
 * @date 2022-08-10 8:21 PM
 */

public class MonotonicQueue {

    // 双链表，支持头部和尾部增删元素
    // 维护其中的元素自尾部到头部单调递增
    LinkedList<Integer> maxq = new LinkedList<>();

    // 在尾部添加一个元素 n，维护 maxq 的单调性质
    public void push(int n) {
        // 将前面小于自己的元素都删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        // 然后将 n 加入尾部
        maxq.addLast(n);
    }

    public int max() {
        // 队头的元素肯定是最大的
        return maxq.getFirst();
    }

    // pop 方法在队头删除元素 n
    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }

}































































