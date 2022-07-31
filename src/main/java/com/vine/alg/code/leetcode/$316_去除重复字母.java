package com.vine.alg.code.leetcode;

import java.util.Stack;

/**
 * @author 阿季
 * @date 2022-07-20 9:19 PM
 */

public class $316_去除重复字母 {


    public static void main(String[] args) {
        $316_去除重复字母 q = new $316_去除重复字母();
        String bcabc = q.removeDuplicateLetters("bcabc");
        System.out.println(bcabc);

    }

    String removeDuplicateLetters(String s) {
        // 存放去重的结果
        Stack<Character> stack = new Stack<>();
        // 记录栈中是否存放过某个字符
        boolean[] inStack = new boolean[256];

        // 记录每个元素的个数
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            // 插入之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop前面的元素
            while (!stack.isEmpty() && stack.peek() > c) {
                // 后面已经没有栈顶的元素了，不能再pop了
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 弹出栈顶元素
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        // 栈中元素插入顺序是反的，需要 reverse 一下
        return sb.reverse().toString();



    }


}































































