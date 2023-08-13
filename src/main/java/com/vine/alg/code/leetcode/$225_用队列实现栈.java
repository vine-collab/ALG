package com.vine.alg.code.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 阿季
 * @date 2023-08-12 22:05
 */

public class $225_用队列实现栈 {

    public static void main(String[] args) {
        $225_用队列实现栈 z = new $225_用队列实现栈();
    }

    /**
     * https://leetcode.cn/problems/implement-stack-using-queues/
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     *
     * 实现 MyStack 类：
     *
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *
     *
     * 注意：
     *
     * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     *
     */

}


class MyStack {

    Queue<Integer> queue;

    Integer top = null;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        this.top = x;
    }

    public int pop() {
        int size = queue.size();
        while(size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        top = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}































































