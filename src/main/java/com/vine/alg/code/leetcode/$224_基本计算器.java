package com.vine.alg.code.leetcode;

import javafx.scene.chart.BarChart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 阿季
 * @date 2023-05-07 3:26 PM
 */

public class $224_基本计算器 {

    public static void main(String[] args) {
        $224_基本计算器 z = new $224_基本计算器();
        int calculate = z.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }


    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     * <p>
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     * <p>
     * 链接：https://leetcode.cn/problems/basic-calculator
     */

    public int calculate(String s) {
        Queue<Character> queue =  new LinkedList<>();
        for(Character character : s.toCharArray()) {
            queue.add(character);
        }
        return helper(queue);
    }


    int helper(Queue<Character> q) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 遇到左括号开始递归
            if(c == '(') {
                num = helper(q);
            }
            if ((!Character.isDigit(c) && c != ' ') || q.isEmpty()) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            // 遇到右括号递归结束
            if(c == ')') {
                break;
            }
        }
        return stack.stream().reduce(Integer::sum).get();
    }


}































































