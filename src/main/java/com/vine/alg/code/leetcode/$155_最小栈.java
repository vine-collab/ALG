package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-08-11 8:54 PM
 */

public class $155_最小栈 {

    public static void main(String[] args) {
        $155_最小栈 z = new $155_最小栈();
    }


}


class MinStack {

    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();


    public MinStack() {

    }

    public void push(int val) {
        stk.push(val);
        // 维护 minStk 栈顶为全栈最小元素
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        } else {
            // 插入的这个元素比较大
            minStk.push(minStk.peek());
        }

    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}

























































